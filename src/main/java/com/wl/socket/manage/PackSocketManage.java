package com.wl.socket.manage;



import com.wl.socket.SocketConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.Socket;

/**
 * @author jianghc
 * @create 2017-05-21 08:27
 **/
public class PackSocketManage {
    private static Logger logger = LogManager.getLogger(PackSocketManage.class);

    public static Socket socket;

    public static void initSocket() {
        try {
            logger.info("【集包】接收客户端启动...");
            socket = new Socket(SocketConfig.packIp, SocketConfig.packPort);
            logger.info("【集包】服务以当前连接状态:{}" , socket.isConnected());
        } catch (Exception e) {
            logger.info("【集包】客户端异常:{}" , e.getMessage());
        }

    }


}
