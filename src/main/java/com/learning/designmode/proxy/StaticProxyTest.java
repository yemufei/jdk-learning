package com.learning.designmode.proxy;

/**
 * @author: mufei
 * @date: 2022/8/22 13:46
 * @Description:
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        Person renter = new Renter();
        RenterProxy proxy = new RenterProxy(renter);
        proxy.rentHouse();
    }

}
