package com.wl.test;

import java.io.*;
import java.net.Socket;

/**
 * Created by Vincent on 2018-06-15.
 */
public class Test {

    public static void main(String[] args){

        try {
            Socket socket = new Socket("10.96.10.163",2000);
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(os));
            bw.write("A5A5011E01000102030405060708090A0B0C0D0E0F1000050001AE5A5A");
            bw.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String mess = br.readLine();
            System.out.println("服務器：" +mess);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
