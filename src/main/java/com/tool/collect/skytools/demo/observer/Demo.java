package com.tool.collect.skytools.demo.observer;

/**
 * @Descriiption
 * @Author bo
 * @Date 2019/4/16 下午5:02
 **/
public class Demo {
    public static void main(String[] args) {
        Subject subject = new Subject();
        ConcreteObserverA observerA = new ConcreteObserverA(subject);
        observerA.observSubject();
        ConcreteObserverB observerB = new ConcreteObserverB(subject);
        observerB.observSubject();

        subject.setState("1");
    }


}
