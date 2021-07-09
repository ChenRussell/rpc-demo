package com.chenrui.rpcsample.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RpcServer {
    // 定义一个线程池
    public final ExecutorService executorService = Executors.newCachedThreadPool();

    // service表示我们要传输过去的对象
    public void publish(final Object service, int port) {
        ServerSocket server = null;
        try {
            // 启动一个服务监听
            server = new ServerSocket(port);
            System.out.println("服务发布成功，监听端口为：" + port);

           // 循环监听
            while (true) {
                Socket accept = server.accept();
                executorService.execute(new ProcessHandler(accept, service));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        RpcHelloImpl rpcHello = new RpcHelloImpl();
        RpcServer rpcServer = new RpcServer();
        rpcServer.publish(rpcHello, 8888);
    }
}
