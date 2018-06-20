package com.wl.socket.manage;



import com.wl.socket.SocketConfig;

import java.net.Socket;

/**
 * @author jianghc
 * @create 2017-05-21 08:27
 **/
public class PackSocketManage {
    public static Socket socket;

    public static void initSocket() {
        try {
            System.out.println("【集包】接收客户端启动...");
            socket = new Socket(SocketConfig.packIp, SocketConfig.packPort);
            System.out.println("【集包】服务以当前连接状态:" + socket.isConnected());
        } catch (Exception e) {
            System.out.println("【集包】客户端异常:" + e.getMessage());
        }

    }


}
