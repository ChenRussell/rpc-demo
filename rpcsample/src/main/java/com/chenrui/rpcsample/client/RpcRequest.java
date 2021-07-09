package com.chenrui.rpcsample.client;

import java.io.Serializable;

// 要想被远程传输，该对象要被序列化
// 客户端和服务端都要有该类
public class RpcRequest implements Serializable {

    private static final long serialVersionUID = 1994L;

    // 告诉服务端当前调用的是哪个类，哪个方法，方法参数是什么等
    private String className;
    private String methodName;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    private Object[] parameters;


}
