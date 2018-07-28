package com.wl.socket.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Vincent on 2018-07-19.
 */
public class PaSendInformation {

    private static Logger logger = LogManager.getLogger(PaSendInformation.class);

    public static boolean[] f = new boolean[48];

    private static byte[] bytes = new byte[19];


    //服務器地址
    public static final String IP_ADR = "10.96.10.180";

    //服務端口
    public static final int PORT = 2000;

    static DataOutputStream outputStream = null;

    public static void sendMesToPLC() {
        final Socket socket;
        try {

            socket = new Socket(IP_ADR, PORT);

            logger.info("扫描服务器连接成功:{}" ,socket.isConnected());

            outputStream = new DataOutputStream(socket.getOutputStream());

            initMsg();

            while (true){

                try {

                    outputStream.write(bytes);
                    break;

                } catch (Exception e) {

                    logger.error("发送命令异常: " ,e.getMessage());

                }finally {
                    if (socket != null) {
                        try {
                            socket.close();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }

        } catch (IOException e) {
            logger.error("扫描上件台服务器异常: " ,e.getMessage());
            e.printStackTrace();
        }

    }

    //初始化数据
    private static void initMsg() {
        bytes[0] = (byte) 165;//码头
        bytes[1] = (byte) 165;//码头
        bytes[2] = (byte) 1;//数据类型
        bytes[3] = (byte) 19;//数据长度
        bytes[4] = (byte) 10;//上位机编号
        bytes[11] = (byte) 0;//备用
        bytes[12] = (byte) 0;//备用
        bytes[13] = (byte) 0;//备用
        bytes[14] = (byte) 0;//备用
        bytes[15] = (byte) 0;//校验
        bytes[16] = (byte) 0;//校验
        bytes[17] = (byte) 90;//马尾
        bytes[18] = (byte) 90;//马尾
    }
}
