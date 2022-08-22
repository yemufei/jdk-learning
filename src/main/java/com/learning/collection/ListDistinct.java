package com.learning.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: mufei
 * @date: 2022/8/22 04:30
 * @Description:
 */
public class ListDistinct {

    //数组列表和链表的效率问题
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        String temp = "aa";
        Long currentTime = System.currentTimeMillis();
        int count = 1000000;
        for (int i = 0; i < count; i++) {
            arrayList.add(temp);
        }
        System.out.println("arrayList time="+(System.currentTimeMillis()-currentTime));
        currentTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            linkedList.add(temp);
        }
        System.out.println("linkedList time="+(System.currentTimeMillis()-currentTime));

        int index = 7878;




    }
}
