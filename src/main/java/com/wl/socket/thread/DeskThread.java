package com.wl.socket.thread;

import com.wl.socket.client.ScanCodeSendStation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;

/**
 * 上件台发送PLC线程
 * Created by Vincent on 2018-06-26.
 */
public class DeskThread {

    private static Logger logger = LogManager.getLogger(DeskThread.class);



    @PostConstruct
    public void initService(){

        ScanCodeSendStation scanCodeSendStation = new ScanCodeSendStation();
        try {
            //scanCodeSendStation.sleep(1000);
            scanCodeSendStation.start();
            logger.info("上件台服务已启动......");
        } catch (Exception e) {
            logger.error("上件台服务启动异常:{}", e.getMessage());
        }

    }

}
