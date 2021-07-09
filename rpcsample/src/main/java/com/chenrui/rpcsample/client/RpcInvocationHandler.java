package com.chenrui.rpcsample.client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// handler做的事就是把request发送过去
public class RpcInvocationHandler implements InvocationHandler {

    private String host;
    private int port;

    public RpcInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 封装好要传输的对象
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setParameters(args);
        // 通过TCPTransport进行传输
        TCPTransport tcpTransport = new TCPTransport(this.host, this.port);
        return tcpTransport.send(rpcRequest);
    }
}
