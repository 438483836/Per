package com.wl.controller;

import com.wl.Env;
import com.wl.entity.*;
import com.wl.service.*;
import com.wl.socket.client.ScanCodeSendStation;
import com.wl.util.DateConversion;
import com.wl.ztService.ZTHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


@Controller
public class MainController {

    private static Logger logger = LogManager.getLogger(MainController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private ComplementService complementService;
    @Autowired
    private DeskInformationService deskInformationService;
    @Autowired
    private ZtoBackInformationService ztoBackInformationService;


    @RequestMapping(value = "home")
    public String home() {
        return "home";
    }

    @RequestMapping("/login")
    public Object login(){
        return "login";
    }

    @RequestMapping(value = "loginVaData")
    public Object loginVaData(HttpServletRequest request, HttpServletResponse response,Model model) throws IOException {
        String userName = request.getParameter("user");
        String password = request.getParameter("pwd");
        logger.info("参数用户名：{},密码：{}",userName,password);
        Map<String, Object> result = userService.loginVaData(userName,password);
        if("0000".equals(result.get("code"))) {
            return "home";
        }
        model.addAttribute("error", result.get("codeDesc"));
        return "login";
    }



    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public void search(HttpServletRequest request, HttpServletResponse response)throws IOException{

        String barCode = request.getParameter("barcode");


        response.setHeader("Content-type","text/html;charset=UTF-8");

        Complement complement = complementService.getByBarcode(barCode);

        if (complement.getSlogan() == null){
            PrintWriter writer = response.getWriter();
            writer.write(complement.getBarCode());
            writer.write("格口号为空，请添加格口号！！！");
        }else {

            PrintWriter writer = response.getWriter();
            writer.write(complement.getBarCode());
            writer.write(complement.getSlogan());
        }


    }

    @RequestMapping(value = "/upSlogan", method = RequestMethod.GET)
    public void upSlogan(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String barCode =request.getParameter("barcode");
        String slogan = request.getParameter("slogan");

        response.setHeader("Content-type","text/html;charset=UTF-8");

        int comp = complementService.saveSlogan(barCode,slogan);

        if (comp > 0){
            response.setStatus(200);
            PrintWriter writer = response.getWriter();
            writer.write(barCode);
            writer.write(slogan);
        }else {

            response.setStatus(500);
        }

    }

    @RequestMapping(value = "/saveData", method = RequestMethod.GET)
    public void saveData(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String packet = request.getParameter("dataPacket");
        String packetSize = request.getParameter("packetSize");
        String plcCode = request.getParameter("plcCode");
        String barCode = request.getParameter("barCode");
        String packageInt = request.getParameter("packageInt");
        String packageDec = request.getParameter("packageDec");
        String slogan = request.getParameter("slogan");
        String backup = request.getParameter("backup");
        String check = request.getParameter("checkData");


        Complement c = new Complement();
        c.setDataPacket(packet);
        c.setPacketSize(packetSize);
        c.setPlcCode(plcCode);
        c.setBarCode(barCode);
        c.setPackageInt(packageInt);
        c.setPackageDec(packageDec);
        c.setSlogan(slogan);
        c.setBackup(backup);
        c.setCheckData(check);

        response.setHeader("Content-type","text/html;charset=UTF-8");

        int comp = complementService.save(c);
        if(comp > 0){
            response.setStatus(200);
        }else {
            response.setStatus(500);
        }


    }

    /**
     * 自动扫描上件台
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/searchDeskMess", method = RequestMethod.GET)
    public void searchDeskMess(HttpServletRequest request, HttpServletResponse response) throws IOException{

        String barCode = request.getParameter("barcode");

        response.setHeader("Content-type","text/html;charset=UTF-8");

        DeskInformation deskInformation = deskInformationService.getByBarcode(barCode);

        if (deskInformation != null){

            ScanCodeSendStation.scanCodeSendPLC(deskInformation);
            logger.info("发送成功！！！");

            PrintWriter writer = response.getWriter();
            writer.write("条码："+deskInformation.getBarcode());
            writer.write("格口号: "+deskInformation.getSlogan());
            response.setStatus(200);

        }else {
            PrintWriter writer = response.getWriter();
            writer.write("该条码不存在！！！");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/upInformation",method = RequestMethod.GET)
    public Object upInformation(HttpServletRequest request, HttpServletResponse response)  throws IOException{
        String sortPortCode = request.getParameter("sortPortCode");
        String packageCode =request.getParameter("packageCode");
        String bindingTime = request.getParameter("bindingTime");
        String employeeCode = request.getParameter("employeeCode");
        String employeeName = request.getParameter("employeeName");
        String siteName = request.getParameter("siteName");
        String uploadTime =  request.getParameter("uploadTime");
        String lineCode = request.getParameter("lineCode");

        ZtoPaMessUpload ztoPaMessUpload = new ZtoPaMessUpload();
        ztoPaMessUpload.setSortPortCode(sortPortCode);
        ztoPaMessUpload.setPackageCode(packageCode);
        ztoPaMessUpload.setBindingTime(DateConversion.getCurrentDate(bindingTime,"yyyy-MM-dd HH:mm:ss"));
        ztoPaMessUpload.setEmployeeCode(employeeCode);
        ztoPaMessUpload.setEmployeeName(employeeName);
        ztoPaMessUpload.setSiteName(siteName);
        ztoPaMessUpload.setUploadTime(DateConversion.getCurrentDate(uploadTime,"yyyy-MM-dd HH:mm:ss"));
        ztoPaMessUpload.setLineCode(lineCode);

        ZtoResponseTO ztoResponseTO = ZTHelper.paMessUpload(ztoPaMessUpload);

        int data = ztoBackInformationService.save(ztoResponseTO);

        if (data > 0){
            logger.info("保存数据成功！！！");
            response.setStatus(200);
            return ztoResponseTO.toString();
        }

        return null;

    }

    @ResponseBody
    @RequestMapping(value = "/sortService",method = RequestMethod.GET)
    public Object sortService(@RequestParam(value = "data",required = true) Object data, @RequestParam(value = "data_digest",required = true) String data_digest, @RequestParam(value = "msg_type",required = true) String msg_type, @RequestParam(value = "company_id",required = true) String company_id) throws IOException{

       if (data != null &&msg_type.equals("SORTING_BAG_BIND")){
           String status = "SUCCESS";
           String packageCode = "01";
           String sortMode = "test";
           String destSiteCode = "01";
           String destSiteName ="test";
           String remark = "";
           ZtoResponseTO ztoResponseTO = new ZtoResponseTO();
           ztoResponseTO.setStatus(status);
           ztoResponseTO.setPackageCode(packageCode);
           ztoResponseTO.setSortMode(sortMode);
           ztoResponseTO.setDestSiteCode(destSiteCode);
           ztoResponseTO.setDestSiteName(destSiteName);
           ztoResponseTO.setRemark(remark);
           //String jsonObj = JSONUtils.toString(ztoResponseTO);
           //logger.info("打印接收数据=====>" + jsonObj);
           return ztoResponseTO;

       }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/saveProduct")
    public Object saveProduct(@RequestParam(value = "uploadFile",required = false)MultipartFile file){
        String fileName = file.getOriginalFilename();
        logger.info("文件名字: {}",fileName);
        Map<String, Object> result = new HashMap<String, Object>();
        String transmissionPath = Env.addImg;
        String dir = DateConversion.getDateFormatter(new Date(), "yyyy-MM-dd");
        String newFileName = UUID.randomUUID().toString().replaceAll("-", "")+".jpg";
        File targetFile = new File(transmissionPath + File.separator +dir, newFileName);
        if (!targetFile.exists()){
            targetFile.mkdirs();
        }
        try {
            file.transferTo(targetFile);
            result.put("code", "0000");
            result.put("codeDesc", "文件上传成功");
            result.put("data", Env.imgUrl+File.separator+dir+File.separator+newFileName);
        } catch (IOException e) {
            logger.error("文件上传报错了");
            logger.error(e.getMessage());
            result.put("code", "0001");
            result.put("codeDesc", "文件上传失败");
        }
        logger.info("显示上传信息：{}" ,result);
        return result;
    }

}

