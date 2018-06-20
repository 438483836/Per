package com.wl.socket.test;

import com.wl.socket.client.GetAutoComplement;

/**
 * Created by Vincent on 2018-06-19.
 */
public class TestAutoCom {

    public static void main(String[] args){

        GetAutoComplement autoComplement = new GetAutoComplement();

        autoComplement.getMesFromPLC();

    }
}
