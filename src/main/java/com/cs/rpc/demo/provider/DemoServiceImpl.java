package com.cs.rpc.demo.provider;

import com.cs.rpc.demo.DemoService;

import java.awt.*;

/**
 * @description:
 * @author: chushi
 * @create: 2020-10-29 15:43
 **/
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello "+name;
    }

    @Override
    public Point multiPoint(Point p, int multi) {
        p.x = p.x*multi;
        p.y = p.y*multi;
        return p;
    }
}
