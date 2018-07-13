package com.wl.util;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.encoding.XMLType;
import java.rmi.RemoteException;

/**
 *
 * Created by Vincent on 2018-07-11.
 */
public class WebServiceUtil {

    private static Logger logger = LogManager.getLogger(WebServiceUtil.class);

    private static String url = "http://192.168.0.110:8086/WebService1.asmx?wsdl";
    private static String namespace = "http://tempuri.org/";
    private static String methodName = "HelloWorld";
    private static String soapActionURI = "http://tempuri.org/HelloWorld";



    public static Object getWebMess(){
        Service service = new Service();
        Call call;
        String result = "";
        try {
            call = (Call) service.createCall();
            call.setTargetEndpointAddress(url);
            call.setUseSOAPAction(true);
            call.setSOAPActionURI(soapActionURI);
            call.setOperationName(new QName(namespace,methodName));
            call.setReturnType(XMLType.XSD_STRING);
            String[] str = new String[0];
            Object obj = call.invoke(str);
            result = (String) obj;
            logger.info("result: " +result);
            return result;
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return null;
    }

}
