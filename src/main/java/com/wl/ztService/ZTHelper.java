package com.wl.ztService;

import com.alibaba.fastjson.JSONObject;
import com.wl.Env;
import com.wl.entity.ZtoPaMessUpload;
import com.wl.entity.ZtoResponseTO;
import com.wl.util.GetSignData;
import com.wl.util.HttpHelper;
import com.wl.util.JSONUtils;
import com.wl.util.OApiException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**中通接口服务
 * Created by Vincent on 2018-07-03.
 */
public class ZTHelper {

    private static Logger logger = LogManager.getLogger(ZTHelper.class);

    /**
     *集包关联信息上传(把枪调用)
     * @param data
     * @return
     */
    public static ZtoResponseTO paMessUpload(ZtoPaMessUpload data) throws UnsupportedEncodingException{

        String requestData = JSONUtils.toString(data);
        String data_digest = GetSignData.getSignData(data);

        String plain = Env.url + "data=" + URLEncoder.encode(requestData,"UTF-8")+ "&data_digest=" + data_digest + "&msg_type=" + Env.msg_type + "&company_id=" + Env.company_id;

        logger.info("接口url: " + plain);

        try {

            JSONObject response = HttpHelper.httpGet(plain);
            logger.info("paMessUpload response:{}", response);

            if (response.containsKey("status")){
                String packageCode = response.getString("packageCode");
                String sortMode = response.getString("sortMode");
                String destSiteCode = response.getString("destSiteCode");
                String destSiteName = response.getString("destSiteName");
                String remark = response.getString("remark");
                if (StringUtils.isEmpty(packageCode)){
                    logger.info("集包号不能为空！！！", packageCode);
                }
                if (StringUtils.isEmpty(sortMode)){
                    logger.info("分拣模式不能为空！！！", sortMode);
                }

                ZtoResponseTO ztoResponseTO = new ZtoResponseTO();
                ztoResponseTO.setPackageCode(packageCode);
                ztoResponseTO.setSortMode(sortMode);
                ztoResponseTO.setDestSiteCode(destSiteCode);
                ztoResponseTO.setDestSiteName(destSiteName);
                ztoResponseTO.setRemark(remark);
                return  ztoResponseTO;
            }

        } catch (OApiException e) {
            e.printStackTrace();
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        return null;
    }

}
