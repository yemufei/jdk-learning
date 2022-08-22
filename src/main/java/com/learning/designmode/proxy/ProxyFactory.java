package com.learning.designmode.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: mufei
 * @date: 2022/8/22 13:51
 * @Description:
 */
public class ProxyFactory<T> implements MethodInterceptor {

    private T target;

    public ProxyFactory(T target) {
        this.target = target;
    }

    // 创建代理对象

    public Object getProxyInstance() {

        // 1.cglib工具类
        Enhancer en = new Enhancer();
        // 2.设置父类
        en.setSuperclass(this.target.getClass());
        // 3.设置回调函数
        en.setCallback(this);

        return en.create();
    }

    //拦截方法
    @Override
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy methodProxy) throws Throwable {
        System.out.println("开始事务...");

        // 执行目标对象的方法
        Object result = method.invoke(target, args);

        System.out.println("提交事务...");
        return result;
    }

}