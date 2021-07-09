package com.chenrui.rpcsample.client;

import java.util.Random;

public class RpcClient {

    public static void main(String[] args) {
        RpcClientProxy rpcClientProxy = new RpcClientProxy();
        /*
          代理模式：
            这个代理对象是为了屏蔽客户端网络通信的部分，安全、线程
         */
        RpcHello hello = rpcClientProxy.getClientProxy(RpcHello.class, "localhost", 8888);
        System.out.println(hello.sayHello(String.format("I am the %sth King of the world!", new Random().nextInt(100))));


    }
}
