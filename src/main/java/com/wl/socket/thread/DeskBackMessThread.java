package com.wl.socket.thread;

import com.wl.service.DeskBackMessService;
import com.wl.socket.client.ScanCodeGetStation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * 上件台返回信息
 * Created by Vincent on 2018-07-16.
 */
public class DeskBackMessThread {

    private static Logger logger = LogManager.getLogger(DeskBackMessThread.class);

    @Autowired
    private DeskBackMessService deskBackMessService;

    @PostConstruct
    public void initService(){

        Thread thread = new Thread(new Runnable() {
            public void run() {
                int i = 0;

                try {

                    Thread.sleep(5 * 1000);

                } catch (InterruptedException e) {

                    e.printStackTrace();

                }

                while (true){
                    if (i > 10) {
                        logger.error("已失败10次，不再尝试连接");
                        break;
                    }

                    ScanCodeGetStation.scanCodeGetPLC(deskBackMessService);
                }
            }
        });
        thread.start();
    }
}
