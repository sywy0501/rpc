package com.cs.rpc.common.protocol;

/**
 * @description:
 * @author: chushi
 * @create: 2020-10-29 15:40
 **/
public interface MessageProtocol {
    byte[] marshallingRequest(Request req) throws Exception;
    Request unmarshallingRequest(byte[] data)throws Exception;
    byte[] marshallingResponse(Response resp)throws Exception;
    Response unmarshallingResponse(byte[] data)throws Exception;
}
