import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: mufei
 * @date: 2022/8/21 13:46
 * @Description:
 */
public class AtomicReferenceDemo {

    public static void main(String[] args) {
        UserInner lzm = new UserInner("lzm", 18);
        UserInner lin = new UserInner("lin", 20);
        AtomicReference<UserInner> atomicReference = new AtomicReference<>();
        atomicReference.set(lzm);
        System.out.println(atomicReference.compareAndSet(lzm, lin)); // true
        System.out.println(atomicReference.get()); // User(userName=lin, age=20)
    }

}


class UserInner{
    String userName;
    int age;

    public UserInner(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }
}
