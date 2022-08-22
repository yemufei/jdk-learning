package com.learning.designmode.proxy;

/**
 * @author: mufei
 * @date: 2022/8/22 13:44
 * @Description:
 */
public class Renter implements Person{

    @Override
    public void rentHouse() {
        System.out.println("租客租房成功！");
    }
}
