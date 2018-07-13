package com.wl.socket.client;

import com.wl.entity.DeskBackMess;
import com.wl.service.DeskBackMessService;
import com.wl.util.ByteUtil;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Vincent on 2018-06-26.
 */
public class ScanCodeGetStation {

    private static byte[] buf = new byte[32];

    //服務器地址
    public static final String IP_ADR = "10.96.10.163";

    //服務端口
    public static final int PORT = 2000;

    static DataInputStream dataInputStream = null;

    public static void scanCodeGetPLC(DeskBackMessService deskBackMessService){

        try {

            final Socket socket = new Socket(IP_ADR,PORT);

            System.out.println("服務器連接狀態：" + socket.isConnected());

            dataInputStream = new DataInputStream(socket.getInputStream());

            int readNum = 0;

            while (true){

                readNum = dataInputStream.read(buf);
                if (readNum > 0){

                    while ((readNum = dataInputStream.read(buf)) > 0){

                        String plcData = ByteUtil.toHexString1(buf);

                        System.out.println("接受======>>" + plcData);

                        String dataPacket = plcData.substring(0,1);

                        String packetSize = plcData.substring(0,1);

                        String plcNum = plcData.substring(0,1);

                        String barcode = plcData.substring(0,1);

                        String packageInt = plcData.substring(0,1);

                        String packageDec = plcData.substring(0,1);

                        String controlMess = plcData.substring(0,1);

                        String checkData = plcData.substring(0,1);

                        DeskBackMess deskBackMess = new DeskBackMess();
                        deskBackMess.setDataPacket(dataPacket);
                        deskBackMess.setPacketSize(packetSize);
                        deskBackMess.setPlcNum(plcNum);
                        deskBackMess.setBarcode(barcode);
                        deskBackMess.setPackageInt(packageInt);
                        deskBackMess.setPackageDec(packageDec);
                        deskBackMess.setControlMess(controlMess);
                        deskBackMess.setCheckData(checkData);


                        int result = deskBackMessService.save(deskBackMess);

                        if (result > 0){
                            System.out.println("数据保存成功！！！！");
                        }

                    }

                }else{
                    System.out.println("PLC没返回信息");
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
