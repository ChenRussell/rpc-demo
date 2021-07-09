package com.chenrui.rpcsample.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPTransport {
    private String host;
    private int port;

    public TCPTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private Socket newSocket() {
        System.out.println("创建一个新的连接！");
        Socket socket;
        try {
            socket = new Socket(host, port);
            return socket;
        } catch (IOException e) {
            throw new RuntimeException("连接建立失败!");
        }
    }

    // 传输的方法，返回一个Object对象，调用远程方法后，返回得到的数据
    public Object send(RpcRequest rpcRequest) {
        Socket socket = null;
        try {
            socket = newSocket();
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            // 通过outputStream将request写到服务端去，这里的outputStream是能够将对象序列化的
            outputStream.writeObject(rpcRequest);
            outputStream.flush();
            ObjectInputStream inputStream = new ObjectInputStream((socket.getInputStream()));
            // 从socket流中读到数据，然后返回
            Object result = inputStream.readObject();
            // 关闭流
            inputStream.close();
            outputStream.close();
            return result;
        } catch (Exception e) {
            throw new RuntimeException("发起RPC调用出现异常!", e);
        }
    }
}
