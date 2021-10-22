package cn.nuist.thread;

public class ThreadTest {
    public static void main(String[] args) {
        Runnable s1 = new SimpleThread("1111111111");
        Thread t1 = new Thread(s1);
        t1.start();


        Runnable s2 = new SimpleThread("2222222222");
        Thread t2 = new Thread(s2);
        t2.start();


    }
}
