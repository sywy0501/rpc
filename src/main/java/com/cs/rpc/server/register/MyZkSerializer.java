package com.cs.rpc.server.register;

import org.I0Itec.zkclient.exception.ZkMarshallingError;
import org.I0Itec.zkclient.serialize.ZkSerializer;

import java.io.UnsupportedEncodingException;

/**
 * @description:
 * @author: chushi
 * @create: 2020-10-29 17:58
 **/
public class MyZkSerializer implements ZkSerializer {

    String charset = "UTF-8";

    @Override
    public byte[] serialize(Object data) throws ZkMarshallingError {
        try {
            return String.valueOf(data).getBytes(charset);
        }catch (UnsupportedEncodingException e){
            throw new ZkMarshallingError(e);
        }
    }

    @Override
    public Object deserialize(byte[] bytes) throws ZkMarshallingError {
        try {
            return new String(bytes,charset);
        }catch (UnsupportedEncodingException e){
            throw new ZkMarshallingError(e);
        }
    }
}
