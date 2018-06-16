package com.wl.socket.test;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * @author jianghc
 * @create 2017-04-16 16:00
 **/
public class SocketClient {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public SocketClient(){
        try {
            socket=new Socket("10.96.10.163",2000);
            out=new ObjectOutputStream(socket.getOutputStream());
            ReadThread readThread=new ReadThread();
            readThread.start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg){
        System.out.println(msg);
        try {
            out.writeObject(msg);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class ReadThread extends Thread{
        boolean runFlag=true;
        public void run(){
            try {
                in=new ObjectInputStream(socket.getInputStream());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            while(runFlag){
                if(socket.isClosed()){
                    return;
                }
                try {
                    Object obj=in.readObject();
                    if(obj instanceof String){
                        System.out.println("Client recive:"+obj);
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        public void exit(){
            runFlag=false;
        }
    }

    public static void main(String[] args) {
        SocketClient socketClient=new SocketClient();
        System.out.println("build socketClient");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        socketClient.sendMessage("A5A5011E01000102030405060708090A0B0C0D0E0F1000050001AE5A5A");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        socketClient.sendMessage("Hello second.");
    }

}
