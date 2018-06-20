package com.wl.socket.client;

import com.wl.util.ByteUtil;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 自动补码
 * Created by Vincent on 2018-06-19.
 */
public class GetAutoComplement {

    public void getMesFromPLC(){

        try {


            //连接服务地址
            final ServerSocket ss = new ServerSocket(2000);

            System.out.println("启动服务器....");

            final Socket s = ss.accept();

            //System.out.println("服务器连接状态......" + ss.accept());

            System.out.println("客户端：" + s.getInetAddress().getLocalHost() + "已连接到服务器");

            Thread tGetData = new Thread(new Runnable() {

                public void run() {

                    DataInputStream dataInputStream = null;

                    try {
                        dataInputStream = new DataInputStream(s.getInputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    byte[] buf = new byte[33];
                    byte[] bytes = new byte[33];

                    int readNum = 0;

                    while (true){
                        try {

                            readNum = dataInputStream.read(buf);

                            if (readNum > 0){

                                System.out.println(ByteUtil.toHexString1(buf));
                                while ((readNum = dataInputStream.read(buf)) > 0){
                                    System.out.println("接受======>>");
                                    System.out.println(ByteUtil.toHexString1(buf));

                                    String plcData = ByteUtil.toHexString1(buf);

                                    System.out.println("plcData======" + plcData);

                                    if (plcData.length() > 0){
                                        System.out.println("返回信息");
                                        OutputStream outputStream = s.getOutputStream();
                                        PrintWriter pw = new PrintWriter(outputStream);
                                        pw.write("A5 A5 01 21 01 01 02 03 04 05 06 07 08 09 0A 0B 0C 0D 0E 0F 10 00 01 00 00 00 01 AA AA 02 01 5A 5A");
                                        pw.flush();
                                    }



                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            /*final Thread tSendData = new Thread(new Runnable() {
                public void run() {

                    DataOutputStream outputStream = null;

                    try {
                        outputStream = new DataOutputStream(socket.getOutputStream());

                        Thread.sleep(1000);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    while (true){
                        System.out.println("===发送===>");

                        try {
                            outputStream.write(ByteUtil.hexStr2ByteArray("A5A50121010102030405060708090A0B0C0D0E0F10000100000001AAAA02015A5A"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });*/
            tGetData.start();
            //tSendData.start();

        } catch (IOException e) {

            System.out.println("客户端异常:" + e.getMessage());

        }

    }


}
