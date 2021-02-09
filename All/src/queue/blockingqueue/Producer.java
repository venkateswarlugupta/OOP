package queue.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private BlockingQueue<String> queue;
    public Producer(BlockingQueue<String> q){
        this.queue=q;
    }

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            String msg=""+i;
            try{
                Thread.sleep(i*1000);
                queue.put(msg);
                System.out.println("Produced : "+msg);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        try{
            queue.put("Exit");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
