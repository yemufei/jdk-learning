package com.learning.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mufei
 * @date: 2022/8/22 04:38
 * @Description:
 */
public class ListSychronized {

    public static void main(String[] args) {

//        List list = Collections.synchronizedList(new ArrayList());
        List list = new ArrayList();
        int count = 10;

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < count; i++) {
                    list.add(i);
                    System.out.println("thread no 1="+i);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < count; i++) {
                    list.add(i);
                    System.out.println("thread no 2="+i);
                }
            }
        }).start();

        System.out.println(list.toString());

    }
}
