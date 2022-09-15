package com.learning.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: mufei
 * @date: 2022/8/22 04:22
 * @Description:
 */
public class ListSort {

    public static void main(String[] args) {

        List<String> testList = Arrays.asList("b","c","j");

        Collections.sort(testList);
        System.out.println(testList.toString());
        Collections.reverse(testList);
        System.out.println(testList.toString());

        testList = Arrays.asList("aab","ac","j");
        testList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                }else if(o1.length() == o2.length()){
                    return 0;
                }
                return -1;
            }
        });
        System.out.println(testList.toString());

    }

}
