package com.wl.test;

import com.wl.entity.DeskInformation;
import com.wl.util.ByteUtil;
import com.wl.util.CheckUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

/**
 * Created by Vincent on 2018-06-15.
 */
public class Test {

    private static Logger logger = LogManager.getLogger(Test.class);

    public static boolean[] f = new boolean[48];
    private static byte[] bytes = new byte[19];

    public static void main(String[] args) throws Exception {
        DeskInformation deskInformation = new DeskInformation();
        deskInformation.setDataPacket("1");
        deskInformation.setPcNum("11");
        deskInformation.setBarcode("641088777");
        deskInformation.setSlogan("255");
        deskInformation.setImportantMess("2");
        String a = CheckUtil.getScanCode(deskInformation);
        byte[] b = ByteUtil.hexStr2ByteArray(a);
        System.out.println(Arrays.toString(b));


        byte c = x[0]; int z = c&0xff;
        System.out.println(z);


      /*  byte a = (byte)234;
        int i = a;
        i = a&0xff;
        System.out.println(i);*/



    }
    public static void setBytes(Integer i, boolean flag) {
        f[i] = false;
        for (int j = 0;j < i; j++){
            int start = i * 16;
            int end = (i + 1) * 16 - 1;

        }

    }

    static byte[] x = {(byte)0xff,(byte)0xff};


    private static void initMsg() {
        bytes[0] = (byte) 165;//码头
        bytes[1] = (byte) 165;//码头
        bytes[2] = (byte) 1;//数据类型
        bytes[3] = (byte) 19;//数据长度
        bytes[4] = (byte) 0;//上位机编号
        bytes[11] = (byte) 0;//其它
        bytes[12] = (byte) 0;//其它
        bytes[13] = (byte) 0;//其它
        bytes[14] = (byte) 0;//其它
        bytes[15] = (byte) 0;//校验
        bytes[16] = (byte) 0;//校验
        bytes[17] = (byte) 90;//码尾
        bytes[18] = (byte) 90;//码尾
        System.out.println(Arrays.toString(bytes));
    }




}
