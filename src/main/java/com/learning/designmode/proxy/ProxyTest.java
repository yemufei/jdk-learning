package com.learning.designmode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author: mufei
 * @date: 2022/8/22 13:48
 * @Description:
 */
public class ProxyTest {

    public static void main(String[] args) {

//        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        //创建被代理的实例对象
        Person renter = new Renter();
        //创建InvocationHandler对象
        InvocationHandler renterHandler = new RenterInvocationHandler<Person>(renter);

        //创建代理对象,代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        Person renterProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(),new Class<?>[]{Person.class}, renterHandler);
        renterProxy.rentHouse();

        //也可以使用下面的方式创建代理类对象，Proxy.newProxyInstance其实就是对下面代码的封装
		/*try {
			//使用Proxy类的getProxyClass静态方法生成一个动态代理类renterProxy
			Class<?> renterProxyClass = Proxy.getProxyClass(Person.class.getClassLoader(), new Class<?>[]{Person.class});
			//获取代理类renterProxy的构造器，参数为InvocationHandler
			Constructor<?> constructor = renterProxyClass.getConstructor(InvocationHandler.class);
			//使用构造器创建一个代理类实例对象
			Person renterProxy = (Person)constructor.newInstance(renterHandler);
			renterProxy.rentHouse();
			//
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    }
}
