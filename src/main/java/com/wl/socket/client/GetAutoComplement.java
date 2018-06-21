package com.wl.socket.client;

import com.wl.entity.Complement;
import com.wl.service.ComplementService;
import com.wl.util.ByteUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 自动补码
 * Created by Vincent on 2018-06-19.
 */
public class GetAutoComplement {

    private static byte[] bytes = new byte[33];
    private static byte[] buf = new byte[33];

    static DataInputStream dataInputStream = null;

    static DataOutputStream dataOutputStream = null;

    public static void getMesFromPLC(ComplementService complementService){

        try {

            //连接服务地址
            final ServerSocket ss = new ServerSocket(2000);

            System.out.println("启动服务器....");

            final Socket s = ss.accept();

            //System.out.println("服务器连接状态......" + ss.accept());

            System.out.println("客户端：" + s.getInetAddress().getLocalHost() + "已连接到客服端");

            try {
                dataInputStream = new DataInputStream(s.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

            int readNum = 0;

            while (true){
                try {

                    readNum = dataInputStream.read(buf);

                    if (readNum > 0){

                        while ((readNum = dataInputStream.read(buf)) > 0){
                            System.out.println("接受======>>");

                            String plcData = ByteUtil.toHexString1(buf);

                            String dataPacket = plcData.substring(4,6);

                            String packetSize = plcData.substring(6,8);

                            String plcCode = plcData.substring(8,10);

                            String barCode = plcData.substring(10,42);

                            String packageInt = plcData.substring(42,46);

                            String packageDec = plcData.substring(46,50);

                            String slogan = plcData.substring(50,54);

                            String backup = plcData.substring(54,58);

                            String checkData = plcData.substring(58,62);


                            Complement complement = new Complement();
                            complement.setDataPacket(Integer.parseInt(dataPacket));
                            complement.setPacketSize(packetSize);
                            complement.setPlcCode(plcCode);
                            complement.setBarCode(barCode);
                            complement.setPackageInt(Integer.parseInt(packageInt));
                            complement.setPackageDec(Integer.parseInt(packageDec));
                            complement.setSlogan(Integer.parseInt(slogan.replaceAll("^0[x|X]", ""),16));
                            complement.setBackup(backup);
                            complement.setCheckData(checkData);

                            int comp = complementService.save(complement);

                            if (comp > 0){

                                System.out.println("保存数据成功！！！");
                            }


                            System.out.println("plcData======" + plcData);

                            if (plcData.length() > 0){
                                System.out.println("返回信息");
                                dataOutputStream = new DataOutputStream(s.getOutputStream());
                                initMsg();
                                while (true) {
                                    dataOutputStream.write(bytes);
                                }

                            }



                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }



        } catch (IOException e) {

            System.out.println("客户端异常:" + e.getMessage());

        }

    }

    //初始化数据
    private static void initMsg() {
        bytes[0] = (byte) 165;//码头
        bytes[1] = (byte) 165;//码头
        bytes[2] = (byte) 1;//数据类型
        bytes[3] = (byte) 33;//数据长度
        bytes[4] = (byte) 1;//上位机编号
        bytes[5] = (byte) 1;//包裹编码
        bytes[6] = (byte) 2;
        bytes[7] = (byte) 3;
        bytes[8] = (byte) 4;
        bytes[9] = (byte) 5;
        bytes[10] = (byte) 6;
        bytes[11] = (byte) 7;
        bytes[12] = (byte) 8;
        bytes[13] = (byte) 9;
        bytes[14] = (byte) 10;
        bytes[15] = (byte) 11;
        bytes[16] = (byte) 12;
        bytes[17] = (byte) 13;
        bytes[18] = (byte) 14;
        bytes[19] = (byte) 15;
        bytes[20] = (byte) 16;
        bytes[21] = (byte) 0;
        bytes[22] = (byte) 1;
        bytes[23] = (byte) 0;
        bytes[24] = (byte) 0;//码尾
        bytes[25] = (byte) 0;//码尾
        bytes[26] = (byte) 1;
        bytes[27] = (byte) 170;
        bytes[28] = (byte) 170;
        bytes[29] = (byte) 2;
        bytes[30] = (byte) 1;
        bytes[31] = (byte) 90;//码尾
        bytes[32] = (byte) 90;//码尾

    }


}
