package com.wl.test;

import com.wl.util.TypeConversion;

/**
 * Created by Vincent on 2018-06-15.
 */
public class Test {

    public static void main(String[] args){

        String str = TypeConversion.sumHexStringBy2("012105000201050102000000000000000000000000000001F4AAAA",2);

        int hexInt = TypeConversion.hexToDecimal(str);

        String hexString = TypeConversion.getHexString4(hexInt);

        System.out.println(hexString);
    }

}
