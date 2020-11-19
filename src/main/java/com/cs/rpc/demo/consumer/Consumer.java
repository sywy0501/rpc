package com.cs.rpc.demo.consumer;

import com.cs.rpc.client.ClientStubProxyFactory;
import com.cs.rpc.client.net.NettyNetClient;
import com.cs.rpc.common.protocol.JavaSerializeMessageProtocol;
import com.cs.rpc.common.protocol.MessageProtocol;
import com.cs.rpc.demo.DemoService;
import com.cs.rpc.discovery.ZookeeperServiceInfoDiscoverer;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: chushi
 * @create: 2020-10-29 15:41
 **/
public class Consumer {

    public static void main(String[] args) {
        ClientStubProxyFactory cspf = new ClientStubProxyFactory();
        //设置服务发现者
        cspf.setSid(new ZookeeperServiceInfoDiscoverer());

        //设置支持的协议
        Map<String, MessageProtocol> supportMessageProtocols = new HashMap<>();
        supportMessageProtocols.put("javas",new JavaSerializeMessageProtocol());
        cspf.setSupportMessageProtocols(supportMessageProtocols);

        //设置网络层实现
        cspf.setNetClient(new NettyNetClient());

        //获取远程服务代理
        DemoService demoService = cspf.getProxy(DemoService.class);
        //执行远程方法
        String hello = demoService.sayHello("world");
        //显示调用结果
        System.out.println(hello);

        System.out.println(demoService.multiPoint(new Point(5,10),2));
    }
}
