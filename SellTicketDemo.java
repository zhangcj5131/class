package cn.nuist.thread;

public class SellTicketDemo {

    public static void main(String[] args) {
//创建SellTicket类的对象
        SellTicket st = new SellTicket();
//创建三个Thread类的对象，把SellTicket对象作为构造方法的参数，并给出对应的窗口名称
        Thread t1 = new Thread(st,"窗口1");
        Thread t2 = new Thread(st,"窗口2");
        Thread t3 = new Thread(st,"窗口3");
        Thread t4 = new Thread(st,"窗口4");
        Thread t5 = new Thread(st,"窗口5");
        Thread t6 = new Thread(st,"窗口6");
//启动线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
