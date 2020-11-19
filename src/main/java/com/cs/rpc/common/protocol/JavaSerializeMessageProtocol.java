package com.cs.rpc.common.protocol;

import java.io.*;

/**
 * @description:
 * @author: chushi
 * @create: 2020-10-29 15:39
 **/
public class JavaSerializeMessageProtocol implements MessageProtocol{

    private byte[] serialize(Object obj) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bout);
        out.writeObject(obj);

        return bout.toByteArray();
    }

    @Override
    public byte[] marshallingRequest(Request req) throws Exception {

        return this.serialize(req);
    }

    @Override
    public Request unmarshallingRequest(byte[] data) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(data));
        return (Request) in.readObject();
    }

    @Override
    public byte[] marshallingResponse(Response rsp) throws Exception {
        return this.serialize(rsp);
    }

    @Override
    public Response unmarshallingResponse(byte[] data) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(data));
        return (Response) in.readObject();
    }
}
