package com.cs.rpc.common.protocol;

/**
 * @description:
 * @author: chushi
 * @create: 2020-10-29 15:34
 **/
public class HttpMessageProtocol implements MessageProtocol{
    @Override
    public byte[] marshallingRequest(Request req) throws Exception {
        return new byte[0];
    }

    @Override
    public Request unmarshallingRequest(byte[] data) throws Exception {
        return null;
    }

    @Override
    public byte[] marshallingResponse(Response resp) throws Exception {
        return new byte[0];
    }

    @Override
    public Response unmarshallingResponse(byte[] data) throws Exception {
        return null;
    }
}
