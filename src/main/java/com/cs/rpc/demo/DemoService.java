package com.cs.rpc.demo;

import java.awt.*;

/**
 * @description:
 * @author: chushi
 * @create: 2020-10-29 15:41
 **/
public interface DemoService {
    String sayHello(String name);

    Point multiPoint(Point p,int multi);
}
