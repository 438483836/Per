package com.wl.socket.thread;

import com.wl.service.AutoPackBackMessService;
import com.wl.socket.client.PaGetInformation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * 自动集包线程
 * Created by Vincent on 2018-07-19.
 */
public class AutoPackBackMessThread {

    private static Logger logger = LogManager.getLogger(AutoPackBackMessThread.class);

    @Autowired
    private AutoPackBackMessService autoPackBackMessService;

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
                    PaGetInformation.getMesFromPLC(autoPackBackMessService);
                }
            }
        });
        //thread.start();
    }


}
