package com.chenrui.rpcsample.server;

import com.chenrui.rpcsample.client.RpcHello;

import java.util.Random;

public class RpcHelloImpl implements RpcHello {
    public String sayHello(String msg) {
        return "Hello RPC client, this is RPC server," + msg + String.format(", random data:%s", new Random().nextInt(20));
    }
}
