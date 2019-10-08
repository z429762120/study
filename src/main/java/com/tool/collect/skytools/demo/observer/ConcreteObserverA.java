package com.tool.collect.skytools.demo.observer;

/**
 * @Descriiption
 * @Author bo
 * @Date 2019/4/16 下午4:58
 **/
public class ConcreteObserverA extends Observer {


    public ConcreteObserverA(Subject subject) {
        this.subject = subject;
    }

    public void observSubject() {
        subject.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("观察者A收到变化了，state="+subject.getState());
    }
}
