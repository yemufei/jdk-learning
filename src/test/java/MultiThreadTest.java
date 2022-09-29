/**
 * @author: mufei
 * @date: 2022/9/19 16:21
 * @Description:
 */
public class MultiThreadTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                System.out.println("Runnable's run method is running");
            }
        }){
            @Override
            public void run() {
                System.out.println("Thread's run method is running");
            }
        }.start();
    }
}
