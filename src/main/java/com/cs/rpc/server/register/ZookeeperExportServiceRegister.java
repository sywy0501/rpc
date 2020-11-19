package com.cs.rpc.server.register;

import com.alibaba.fastjson.JSON;
import com.cs.rpc.discovery.ServiceInfo;
import com.cs.rpc.util.PropertiesUtils;
import org.I0Itec.zkclient.ZkClient;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLEncoder;

/**
 * @description:
 * @author: chushi
 * @create: 2020-10-29 17:58
 **/
public class ZookeeperExportServiceRegister extends DefaultServiceRegister implements ServiceRegister {

    private ZkClient client;

    private String centerRootPath = "/Rpc-framework";

    public ZookeeperExportServiceRegister() {
        String addr = PropertiesUtils.getProperties("zk.address");
        client = new ZkClient(addr);
        client.setZkSerializer(new MyZkSerializer());
    }

    @Override
    public void register(ServiceObject so, String protocol, int port) throws Exception {
        super.register(so, protocol, port);
        ServiceInfo soInfo = new ServiceInfo();

        String host = InetAddress.getLocalHost().getHostAddress();
        String address = host + ":" + port;
        soInfo.setAddress(address);
        soInfo.setName(so.getInterf().getName());
        soInfo.setProtocol(protocol);
        this.exportService(soInfo);
    }

    private void exportService(ServiceInfo soInfo) {
        String serviceName = soInfo.getName();
        String uri = JSON.toJSONString(soInfo);
        try {
            uri = URLEncoder.encode(uri,"UTF-8");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        String servicePath = centerRootPath+"/"+serviceName+"/service";
        if (!client.exists(servicePath)){
            client.createPersistent(servicePath,true);
        }
        String uriPath = servicePath + "/" +uri;
        if (client.exists(uriPath)){
            client.delete(uriPath);
        }
        client.createEphemeral(uriPath);
    }


}
