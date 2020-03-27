package cn.majingjing.ws.server;

import javax.xml.ws.Endpoint;

/**
 * 
 * @author JingjingMa
 * @date 2017-11-29
 */
public class WebServicePublish {

    public static void main(String[] args) {
        String address = "http://127.0.0.1:9999/ws/demo2";
        Endpoint.publish(address , new Demo2Port());
        System.out.println("发布webservice成功!");
        
    }
}
