package com.wl.remote;

import com.wl.util.ByteUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Vincent on 2018-06-16.
 */
public class MyClient {

    //服務器地址
    public static final String IP_ADR = "10.96.10.10";

    //服務端口
    public static final int PORT = 2000;

    public static void main(String[] args){

        System.out.println("客戶端啟動.......");

        try {

            final Socket socket = new Socket(IP_ADR, PORT);

            System.out.println("服務器連接狀態：" + socket.isConnected());

            Thread threadGetData = new Thread(new Runnable() {

                public void run() {

                    DataInputStream inputStream = null;

                    try {
                        inputStream = new DataInputStream(socket.getInputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    byte[] buf = new byte[1024];

                    int readNum = 0;

                    while (true){
                        try {

                            readNum = inputStream.read(buf);

                            if (readNum > 0){

                                System.out.println(ByteUtil.toHexString1(buf));
                                while ((readNum = inputStream.read(buf)) > 0){
                                    System.out.println("接受======》");
                                    System.out.println(ByteUtil.toHexString1(buf));
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            final Thread threadSendData = new Thread(new Runnable() {
                public void run() {

                    DataOutputStream outputStream = null;

                    try {
                        outputStream = new DataOutputStream(socket.getOutputStream());

                        Thread.sleep(1000);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    while (true){
                        System.out.println("===發送===>");

                        try {
                            outputStream.write(ByteUtil.hexStr2ByteArray("A5A5011E01000102030405060708090A0B0C0D0E0F100005000001AE5A5A"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            threadGetData.start();
            threadSendData.start();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客戶端異常：" + e.getMessage());
        }
    }

}
