package com.tool.collect.skytools.demo.observer;

/**
 * @Descriiption
 * @Author bo
 * @Date 2019/4/16 下午4:51
 **/
public abstract class Observer {
    protected Subject subject;

    public abstract void update();
}
