package com.tool.collect.skytools.demo.observer;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Descriiption
 * @Author bo
 * @Date 2019/4/16 下午4:50
 **/
@Data
public class Subject {
    List<Observer> list = new ArrayList<>();
    private String state;

    public void setState(String state){
        this.state = state;
        System.out.println("subject状态发生改变");
        notifyAllObserver();
    }


    public void addObserver(Observer observer) {
        list.add(observer);
    }

    private void notifyAllObserver() {
        for (Observer observer : list) {
            observer.update();
        }
    }
}
