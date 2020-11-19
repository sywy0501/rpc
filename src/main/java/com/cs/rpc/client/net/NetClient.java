package com.cs.rpc.client.net;

import com.cs.rpc.discovery.ServiceInfo;

/**
 * @description:
 * @author: chushi
 * @create: 2020-10-29 15:35
 **/
public interface NetClient {
    byte[] sendRequest(byte[] data, ServiceInfo sinfo)throws Throwable;
}
