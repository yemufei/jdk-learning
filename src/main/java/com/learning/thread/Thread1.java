package com.learning.thread;

/**
 * @author: mufei
 * @date: 2022/9/30 14:03
 * @Description:
 */
public class Thread1 {
    static int a = 1;

    public static void main(String[] args) {
        new Thread(() -> {
            String thredName = Thread.currentThread().getName();
            for(int i=0;i<10;i++){
                a = a + 1;
                output(a);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"111").start();
        new Thread(() -> {
//            String thredName = Thread.currentThread().getName();
            for(int i=0;i<10;i++){
                a = a + 1;
//                System.out.println(thredName+"-> a="+a);

                output(a);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"222").start();

//        new Thread().start();
    }

    private static synchronized void output(int a) {
        String thredName = Thread.currentThread().getName();
        System.out.println(thredName+"-> a="+a);
    }
}

