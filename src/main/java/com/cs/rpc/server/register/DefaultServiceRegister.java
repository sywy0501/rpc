package com.cs.rpc.server.register;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: chushi
 * @create: 2020-10-29 17:57
 **/
public class DefaultServiceRegister implements ServiceRegister{

    private Map<String,ServiceObject> serviceObjectMap = new HashMap<>();

    @Override
    public void register(ServiceObject so, String protocol, int port) throws Exception {
        if (so==null){
            throw new IllegalArgumentException("参数不能为空");
        }
        this.serviceObjectMap.put(so.getName(),so);
    }

    @Override
    public ServiceObject getServiceObject(String name) throws Exception {
        return this.serviceObjectMap.get(name);
    }
}
