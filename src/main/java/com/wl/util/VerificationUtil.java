package com.wl.util;

import com.wl.entity.Complement;
import org.springframework.util.StringUtils;

/**
 * 校验码工具类
 * Created by Vincent on 2018-06-24.
 */
public class VerificationUtil {

    /**
     * 自动补码校验
     * @param complement
     * @return
     */
    public static String autoComplementV(Complement complement){

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(complement.getDataPacket());//数据包
        stringBuffer.append(TypeConversion.getHexString2(Integer.parseInt(complement.getPacketSize())));//数据包总长度
        stringBuffer.append(complement.getPlcCode());//plc站口
        stringBuffer.append(complement.getBarCode());//条码
        stringBuffer.append(complement.getPackageInt());//包裹重量整数位
        stringBuffer.append(complement.getPackageDec());//包裹重量小数位
        stringBuffer.append(TypeConversion.getHexString4(Integer.parseInt(complement.getSlogan())));//格口号码
        if (StringUtils.isEmpty(complement.getSlogan())){
            stringBuffer.append("5555");
        }else {
            stringBuffer.append("AAAA");
        }

        String lString = stringBuffer.toString();

        String str = TypeConversion.sumHexStringBy2(lString,2);

        int hexInt = TypeConversion.hexToDecimal(str);

        String hexString = TypeConversion.getHexString4(hexInt);


        return hexString;
    }

}
