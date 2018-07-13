package com.wl.socket.client;

import com.wl.entity.DeskInformation;
import com.wl.util.ByteUtil;
import com.wl.util.CheckUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *扫描上件台发送给PLC
 * Created by Vincent on 2018-06-26.
 */
public class ScanCodeSendStation extends Thread{

    private static Logger logger = LogManager.getLogger(ScanCodeSendStation.class);

    public ScanCodeSendStation(){

    }

    //服務器地址
    public static final String IP_ADR = "192.168.0.108";

    //服務端口
    public static final int PORT = 2000;

    static DataOutputStream outputStream = null;

    public static void scanCodeSendPLC(final DeskInformation deskInformation) {
        final Socket socket;
        try {

            socket = new Socket(IP_ADR, PORT);
            System.out.println("服務器連接狀態：" + socket.isConnected());

            outputStream = new DataOutputStream(socket.getOutputStream());


            while (true){

                try {
                    outputStream.write(ByteUtil.hexStr2ByteArray(CheckUtil.getScanCode(deskInformation)));
                    logger.info("发送命令: " + CheckUtil.getScanCode(deskInformation));
                    break;

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
