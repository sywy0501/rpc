package com.cs.rpc.discovery;

/**
 * @description:
 * @author: chushi
 * @create: 2020-10-29 15:45
 **/
public class ServiceInfo {

    private String name;

    private String protocol;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
