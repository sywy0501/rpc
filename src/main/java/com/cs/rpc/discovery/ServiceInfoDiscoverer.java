package com.cs.rpc.discovery;

import java.util.List;

/**
 * @description:
 * @author: chushi
 * @create: 2020-10-29 15:45
 **/
public interface ServiceInfoDiscoverer {
    List<ServiceInfo> getServiceInfo(String name);
}
