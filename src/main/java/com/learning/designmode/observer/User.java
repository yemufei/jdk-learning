package com.learning.designmode.observer;

/**
 * @author: mufei
 * @date: 2022/9/30 16:44
 * @Description:
 */
public class User implements Observer{
    private String name; private String message;

    public User(String name) {

        this.name = name;

    }

    @Override

    public void update(String message) {

        this.message = message;

        read();

    }

    public void read() {

        System.out.println(name + " 收到推送消息： " + message);

    }
}
