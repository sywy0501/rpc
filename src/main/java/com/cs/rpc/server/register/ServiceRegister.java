package com.cs.rpc.server.register;

/**
 * @description:
 * @author: chushi
 * @create: 2020-10-29 17:58
 **/
public interface ServiceRegister {

    void register(ServiceObject so,String protocol,int port)throws Exception;

    ServiceObject getServiceObject(String name)throws Exception;
}
