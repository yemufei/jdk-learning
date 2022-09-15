import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author: mufei
 * @date: 2022/8/21 13:49
 * @Description:
 */
public class ABADemo2 {
    private static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {
        new Thread(() -> {
            //获得版本号为1
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + " 的版本号为：" + stamp);
            //睡眠1s是为了执行下面的一个线程使得版本号都为1开始
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //100修改为101再修改为100 产生ABA问题 每次修改版本号加1
            atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);//版本号为2
            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);//版本号为3
        }).start();

        new Thread(() -> {
            //获得版本号为1
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + " 的版本号为：" + stamp);
            //睡眠3s是为了让上面的线程先执行完 产生ABA
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //由于上面的线程版本号为3 这个线程版本号为2 所以返回false
            boolean b = atomicStampedReference.compareAndSet(100, 2020, stamp, stamp + 1);
            System.out.println(b); // false
            System.out.println(atomicStampedReference.getReference()); // 100
        }).start();
    }
}