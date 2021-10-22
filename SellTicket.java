package cn.nuist.thread;

public class SellTicket implements Runnable{
    private int tickets = 100;
    private Object obj = new Object();
    //在SellTicket类中重写run()方法实现卖票，代码步骤如下
    @Override
    public void run() {
        while (true) {

            synchronized (SellTicket.class){
                if(tickets <= 0){
//卖完了
                    break;
                }else{
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "在卖票,还剩下" +tickets + "张票");
                    tickets--;
                }
            }

        }
    }
}

