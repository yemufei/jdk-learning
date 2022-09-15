import com.learning.bo.Student;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: mufei
 * @date: 2022/8/21 05:54
 * @Description:
 */
public class Test {

    public static void main(String[] args) {

        Student stuA = new Student("张三", "20");
        Student stuB = new Student("张三", "20");
        System.out.println(stuA.equals(stuB));                   // true
        System.out.println(stuA == stuB);                        // false
        System.out.println(stuA.hashCode() == stuB.hashCode());  // true

        Set<Student> set = new HashSet<>();
        set.add(stuA);
        set.add(stuB);
        set.add(null);
        System.out.println(set.size());


        int i = 45;
        System.out.println(i*32==(i<<5));
        System.out.println(i*31==((i<<5)-i));
    }

}
