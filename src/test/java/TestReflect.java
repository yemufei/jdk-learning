import com.learning.reflect.Student;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

/**
 * @author: mufei
 * @date: 2022/9/15 10:18
 * @Description:
 */
/*本类用于反射的测试*/
public class TestReflect {
    //1.可以创建程序的入口函数main()--此处不用
    //2.通过单元测试方法，获取目标类Student对应的字节码对象
    public static void main(String[] args) throws ClassNotFoundException {
        //练习获取字节码对象的3种方式
        Class<?> clazz1 = Class.forName("com.learning.reflect.Student");
        Class<?> clazz2 = Student.class;
        Class<?> clazz3 = new Student().getClass();

        //打印的是Student类对应的字节码对象
        System.out.println(clazz1);//class com.reflection.Student
        //获取Student类对应的字节码对象clazz1的名字
        System.out.println(clazz1.getName());//com.reflection.Student
        //通过Student类对应的字节码对象，获取Student类的类名
        System.out.println(clazz1.getSimpleName());
        //通过Student类对应的字节码对象，获取Student类对应的包对象
        System.out.println(clazz1.getPackage());
        //通过Student类对应的字节码对象，先获取Student类对应的包对象，再获取这个包对象的名字
        System.out.println(clazz1.getPackage().getName());
    }

    @Test
    public  void test() throws Exception {
        //1.加载Class对象
        Class clazz = Class.forName("com.learning.reflect.Student");


        //2.获取所有公有构造方法
        System.out.println("**********************所有公有构造方法*********************************");
        Constructor[] conArray = clazz.getConstructors();
        for(Constructor c : conArray){
            System.out.println(c);
        }


        System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
        conArray = clazz.getDeclaredConstructors();
        for(Constructor c : conArray){
            System.out.println(c);
        }

        System.out.println("*****************获取公有、无参的构造方法*******************************");
        Constructor con = clazz.getConstructor(null);
        //1>、因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型
        //2>、返回的是描述这个无参构造函数的类对象。

        System.out.println("con = " + con);
        //调用构造方法
        Object obj = con.newInstance();
        //	System.out.println("obj = " + obj);
        //	Student stu = (Student)obj;

        System.out.println("******************获取私有构造方法，并调用*******************************");
        con = clazz.getDeclaredConstructor(String.class);
        System.out.println(con);
        //调用构造方法
        con.setAccessible(true);//暴力访问(忽略掉访问修饰符)
        obj = con.newInstance("男");
    }

}
