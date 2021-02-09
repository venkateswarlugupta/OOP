package queue.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread{
    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> q){
        this.queue=q;
    }

    public void run(){
        try{
            String msg;
            while(!(msg = queue.take()).equalsIgnoreCase("Exit")){
                Thread.sleep(5*1000);
                System.out.println("Consumed : "+msg);
            }
            System.out.println("Done Consuming");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
