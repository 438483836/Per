package com.wl.socket.thread;

import com.wl.service.ComplementService;
import com.wl.socket.client.GetAutoComplement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * 自动补码线程
 * Created by Vincent on 2018-06-21.
 */
public class GetAutoComplementThread {

    private static Logger logger = LogManager.getLogger(GetAutoComplementThread.class);

    @Autowired
    private ComplementService complementService;

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

                while (true) {
                    if (i > 10) {
                        logger.error("已失败10次，不再尝试连接");
                        break;
                    }
                    try {

                        GetAutoComplement.getMesFromPLC(complementService);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        thread.start();

    }

}
