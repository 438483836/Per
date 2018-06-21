package com.wl.test;

/**
 * Created by Vincent on 2018-06-15.
 */
public class Test {

    public static void main(String[] args){

        String str = "1213";
        int a = Integer.parseInt(str.replaceAll("^0[x|X]", ""),16);
        System.out.println(a);

    }

}
