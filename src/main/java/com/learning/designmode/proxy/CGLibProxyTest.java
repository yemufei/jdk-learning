package com.learning.designmode.proxy;

/**
 * @author: mufei
 * @date: 2022/8/22 13:53
 * @Description:
 */
public class CGLibProxyTest {
    public static void main(String[] args) {

        UserService userService = new UserService();
        ProxyFactory<UserService> proxyFactory = new ProxyFactory<>(userService);
        UserService proxyInstance = (UserService)proxyFactory.getProxyInstance();
        proxyInstance.getName();
    }
}
