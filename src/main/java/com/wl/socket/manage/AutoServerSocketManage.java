package com.wl.socket.manage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Vincent on 2018-06-21.
 */
public class AutoServerSocketManage {

    public static ServerSocket serverSocket;

    public static void initServerSocket(){

        try {
            serverSocket = new ServerSocket(2000);

            System.out.println("启动服务器....");

            final Socket s = serverSocket.accept();

            System.out.println("客户端：" + s.getInetAddress().getLocalHost() + "已连接到客服端");


        } catch (IOException e) {

            System.out.println("服务端异常....." + e.getMessage());

        }




    }

}
