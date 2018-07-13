package com.wl.socket.thread;

import com.wl.service.DeskBackMessService;
import com.wl.socket.client.ScanCodeSendStation;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * 上件台线程
 * Created by Vincent on 2018-06-26.
 */
public class DeskThread {

    @Autowired
    private DeskBackMessService deskBackMessService;


    @PostConstruct
    public void initService(){

        ScanCodeSendStation scanCodeSendStation = new ScanCodeSendStation();
        try {
            scanCodeSendStation.sleep(1000);
            scanCodeSendStation.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
