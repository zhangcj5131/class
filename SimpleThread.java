package cn.nuist.thread;

public class SimpleThread implements Runnable{
    private String str = null;
    public SimpleThread(String str){
        this.str = str;
    }
    //
    private void show_str(){

        int i = 0;
        synchronized (DeadLock.class) {
            for (i = 0; i < str.length(); i++) {
                System.out.print(str.charAt(i));
            }
            System.out.println();
        }



    }


    @Override
    public void run() {
        while(true){
            show_str();
        }


    }
}
