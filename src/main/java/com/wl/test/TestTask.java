package com.wl.test;

import com.wl.util.DateConversion;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Vincent on 2018-07-24.
 */
@Component("testTask")
public class TestTask {

    @Scheduled(cron = "0/10 * * * * ?")
    public void showTime(){
        System.out.println("每十秒发一次: " + DateConversion.getDateFormatter(new Date(),"yyyy-MM-dd HH:mm:ss"));
    }
}
