package com.tool.collect.skytools.demo.observer;

/**
 * @Descriiption
 * @Author bo
 * @Date 2019/4/16 下午4:58
 **/
public class ConcreteObserverB extends Observer {


    public ConcreteObserverB(Subject subject) {
        this.subject = subject;
    }

    public void observSubject() {
        subject.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("观察者B收到变化了，state="+subject.getState());
    }
}
