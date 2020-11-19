package com.cs.rpc.demo.provider;

import com.cs.rpc.common.protocol.JavaSerializeMessageProtocol;
import com.cs.rpc.demo.DemoService;
import com.cs.rpc.server.NettyRpcServer;
import com.cs.rpc.server.RequestHandler;
import com.cs.rpc.server.RpcServer;
import com.cs.rpc.server.register.ServiceObject;
import com.cs.rpc.server.register.ServiceRegister;
import com.cs.rpc.server.register.ZookeeperExportServiceRegister;
import com.cs.rpc.util.PropertiesUtils;

/**
 * @description:
 * @author: chushi
 * @create: 2020-10-29 15:43
 **/
public class Provider {

    public static void main(String[] args) throws Exception {
        int port = Integer.parseInt(PropertiesUtils.getProperties("rpc.port"));
        String protocol = PropertiesUtils.getProperties("rpc.protocol");

        // 服务注册
        ServiceRegister sr = new ZookeeperExportServiceRegister();
        DemoService ds = new DemoServiceImpl();
        ServiceObject so = new ServiceObject(DemoService.class.getName(), DemoService.class, ds);
        sr.register(so, protocol, port);

        RequestHandler reqHandler = new RequestHandler(new JavaSerializeMessageProtocol(), sr);

        RpcServer server = new NettyRpcServer(port, protocol, reqHandler);
        server.start();
        System.in.read(); // 按任意键退出
        server.stop();
    }
}
