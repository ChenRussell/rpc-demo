package com.chenrui.rpcsample.client;

import java.lang.reflect.Proxy;

public class RpcClientProxy {


    public RpcHello getClientProxy(Class<RpcHello> rpcClass, String host, int port) {
        return (RpcHello) Proxy.newProxyInstance(rpcClass.getClassLoader(), new Class[]{rpcClass}, new RpcInvocationHandler(host, port));
    }
}
