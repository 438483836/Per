package com.wl.socket.client;

import com.wl.entity.AutoPackBackMess;
import com.wl.service.AutoPackBackMessService;
import com.wl.util.ByteUtil;
import com.wl.util.CheckUtil;
import com.wl.util.TypeConversion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 自动集包
 * Created by Vincent on 2018-07-18.
 */
public class PaGetInformation {

    private static Logger logger = LogManager.getLogger(PaGetInformation.class);

    public static byte[] buf = new byte[179];

    static DataInputStream dataInputStream = null;
    static DataOutputStream dataOutputStream = null;

    public static void getMesFromPLC(AutoPackBackMessService autoPackBackMessService){

        try {

            final ServerSocket ss = new ServerSocket(2000);
            logger.info("自动集包服务启动....");
            final Socket s = ss.accept();
            logger.info("客户端：" + s.getInetAddress().getLocalHost() + "已连接到客服端");
            dataInputStream = new DataInputStream(s.getInputStream());

            int readNum = 0;

            while(true){

                readNum = dataInputStream.read(buf);

                if (readNum > 0){
                    while ((readNum = dataInputStream.read(buf)) > 0){

                        byte[] dataType = ByteUtil.subBytes(buf,2,1);//数据类型
                        byte[] packSize = ByteUtil.subBytes(buf,3,1);//数据包总长度
                        byte[] plcNum = ByteUtil.subBytes(buf,4,1);//plc站号
                        byte[] exportNum = ByteUtil.subBytes(buf,5,2);//出口编号1
                        byte[] barcodeLength = ByteUtil.subBytes(buf,7,1);//条码长度1
                        byte[] barCode = ByteUtil.subBytes(buf,8,15);//条码编号1

                        byte[] exportNum2 = ByteUtil.subBytes(buf,61,2);//出口编号2
                        byte[] barcodeLength2 = ByteUtil.subBytes(buf,63,1);//条码长度2
                        byte[] barCode2 = ByteUtil.subBytes(buf,64,15);//条码编号2

                        byte[] exportNum3 = ByteUtil.subBytes(buf,117,2);//出口编号3
                        byte[] barcodeLength3 = ByteUtil.subBytes(buf,119,1);//条码长度3
                        byte[] barCode3 = ByteUtil.subBytes(buf,120,15);//条码编号3
                        byte[] responseData = ByteUtil.subBytes(buf,174,1);

                        String responseDataStr = ByteUtil.toHexString1(responseData);

                        String dataTypeStr = ByteUtil.toHexString1(dataType);
                        String packSizeStr =ByteUtil.toHexString1(packSize);
                        String plcNumStr = ByteUtil.toHexString1(plcNum);

                        String exportNumStr = ByteUtil.toHexString1(exportNum);
                        String barcodeLengthStr =ByteUtil.toHexString1(barcodeLength);
                        String barCodeStr = ByteUtil.toHexString1(barCode);

                        String exportNumStr2 = ByteUtil.toHexString1(exportNum2);
                        String barcodeLengthStr2 =ByteUtil.toHexString1(barcodeLength2);
                        String barCodeStr2 = ByteUtil.toHexString1(barCode2);

                        String exportNumStr3 = ByteUtil.toHexString1(exportNum3);
                        String barcodeLengthStr3 =ByteUtil.toHexString1(barcodeLength3);
                        String barCodeStr3 = ByteUtil.toHexString1(barCode3);


                        AutoPackBackMess autoPackBackMess = new AutoPackBackMess();
                        autoPackBackMess.setDataPacket(String.valueOf(TypeConversion.hexToDecimal(dataTypeStr)));
                        autoPackBackMess.setPackSize(String.valueOf(TypeConversion.hexToDecimal(packSizeStr)));
                        autoPackBackMess.setPlcNum(String.valueOf(TypeConversion.hexToDecimal(plcNumStr)));

                        autoPackBackMess.setExportNum(String.valueOf(TypeConversion.hexToDecimal(exportNumStr)));
                        autoPackBackMess.setBarcodeLength(String.valueOf(TypeConversion.hexToDecimal(barcodeLengthStr)));
                        autoPackBackMess.setBarcode(String.valueOf(TypeConversion.hexToDecimal(barCodeStr)).substring(0,TypeConversion.hexToDecimal(barcodeLengthStr)));

                        autoPackBackMess.setExportNum2(String.valueOf(TypeConversion.hexToDecimal(exportNumStr2)));
                        autoPackBackMess.setBarcodeLength2(String.valueOf(TypeConversion.hexToDecimal(barcodeLengthStr2)));
                        autoPackBackMess.setBarcode2(String.valueOf(TypeConversion.hexToDecimal(barCodeStr2)).substring(0,TypeConversion.hexToDecimal(barcodeLengthStr2)));

                        autoPackBackMess.setExportNum3(String.valueOf(TypeConversion.hexToDecimal(exportNumStr3)));
                        autoPackBackMess.setBarcodeLength3(String.valueOf(TypeConversion.hexToDecimal(barcodeLengthStr3)));
                        autoPackBackMess.setBarcode3(String.valueOf(TypeConversion.hexToDecimal(barCodeStr3)).substring(0,TypeConversion.hexToDecimal(barcodeLengthStr3)));


                        int data =  autoPackBackMessService.save(autoPackBackMess);

                        if (data > 0){
                            logger.info("自动集包数据保存成功！！！");
                            dataOutputStream = new DataOutputStream(s.getOutputStream());
                            while (true){
                                dataOutputStream.write(ByteUtil.hexStr2ByteArray(CheckUtil.autoPackSendPLC(responseDataStr)));
                                logger.info("自动集包PC发送命令给PLC: ",CheckUtil.autoPackSendPLC(responseDataStr));
                                break;
                            }

                        }



                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
