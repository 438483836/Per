package com.wl.socket.client;

import com.wl.util.ByteUtil;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Vincent on 2018-06-19.
 */
public class SendAutoComplement {

    //服務器地址
    public static final String IP_ADR = "10.96.10.163";

    //服務端口
    public static final int PORT = 2000;

    public void sendMsgToPLC(){

        try {
            final Socket socket = new Socket(IP_ADR, PORT);

            System.out.println("服務器連接狀態：" + socket.isConnected());

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
                        System.out.println("===发送===>");

                        try {
                            outputStream.write(ByteUtil.hexStr2ByteArray("A5A5011E01000102030405060708090A0B0C0D0E0F100005000001AE5A5A"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            threadSendData.start();


        } catch (IOException e) {
            System.out.println("客户端异常:" + e.getMessage());
        }



    }
}
