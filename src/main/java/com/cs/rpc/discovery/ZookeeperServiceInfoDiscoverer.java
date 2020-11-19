package com.cs.rpc.discovery;

import com.alibaba.fastjson.JSON;
import com.cs.rpc.server.register.MyZkSerializer;
import com.cs.rpc.util.PropertiesUtils;
import org.I0Itec.zkclient.ZkClient;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: Zookeeper 方式获取远程服务信息类
 * @author: chushi
 * @create: 2020-10-29 15:46
 **/
public class ZookeeperServiceInfoDiscoverer implements ServiceInfoDiscoverer {

    ZkClient client;

    private String centerRootPath = "/Rpc-framework";

    public ZookeeperServiceInfoDiscoverer() {
        String addr = PropertiesUtils.getProperties("zk.address");
        client = new ZkClient(addr);
        client.setZkSerializer(new MyZkSerializer());
    }

    @Override
    public List<ServiceInfo> getServiceInfo(String name) {
        String servicePath = centerRootPath + "/" + name + "/service";
        List<String> children = client.getChildren(servicePath);
        List<ServiceInfo> resources = new ArrayList<ServiceInfo>();
        for (String ch : children) {
            try {
                String deCh = URLDecoder.decode(ch, "UTF-8");
                ServiceInfo r = JSON.parseObject(deCh, ServiceInfo.class);
                resources.add(r);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return resources;
    }
}
