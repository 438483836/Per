package com.wl.socket.thread;

import com.wl.util.WebServiceUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;

/**
 * Created by Vincent on 2018-07-11.
 */
public class WebServiceThread {

    private static Logger logger = LogManager.getLogger(WebServiceThread.class);

    @PostConstruct
    public void initService(){

        Thread webThread = new Thread(new Runnable() {
            public void run() {
                logger.info("webService is start");
                int i = 0;
                try {
                    Thread.sleep(5 * 1000); //5秒后启动异步线程
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (true){
                    if (i > 10){
                        logger.error("接受数据失败！！！");
                        break;
                    }
                    Object obj =WebServiceUtil.getWebMess();
                    if (obj != null){
                        logger.info("接受数据成功" + obj);
                        break;
                    }
                }

            }
        });
        //webThread.start();

    }
}
