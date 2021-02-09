package com.venkateswarlu;

import java.util.Random;


public class Main {

    public static void main(String[] args) {
        Message message=new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();
        /*(new Thread(new Reader(message))).start();
        Message message1=new Message();
        (new Thread(new Writer(message1))).start();
        t1=new Thread(new Writer(message));
        t1.start();

        (new Thread(new Reader(message1))).start();*/
    }
}

class Message {
    private String message;
    private boolean empty=true;
    public synchronized String read(){
        while(empty){
            try{
                wait();
            }catch(InterruptedException e) {
                System.out.println("Exception while reading");
            }
        }
        empty=true;
        notifyAll();
        return message;
    }
    public synchronized void write(String message){
        while(!empty){
            try{
                wait();
            }catch(InterruptedException e){
                System.out.println("Exception while writing");
            }
        }
        empty=false;
        this.message=message;
        notifyAll();
    }
}
class ThreadColors {
    public static final String ANSI_RESET="\u001B[0m";
    public static final String ANSI_BLACK="\u001B[30m";
    public static final String ANSI_RED="\u001B[31m";
    public static final String ANSI_GREEN="\u001B[32m";
    public static final String ANSI_LIGHT_YELLOW = "\u001B[93m";
    public static final String ANSI_YELLOW = "\u001b[33m";
    public static final String ANSI_BLUE="\u001B[34m";
    public static final String ANSI_PURPLE="\u001B[35m";
    public static final String ANSI_CYAN="\u001B[36m";
    public static final String ANSI_WHITE="\u001B[37m";
}
class Writer implements Runnable{
    private Message message;
    public Writer(Message message){
        this.message=message;
    }
    public void run(){
        String[] messages ={
                "Humpty Dumpty sat on a wall",
                "Humpty Dumpty had a great fall",
                "All the king's horses and all the king's men",
                "Couldn't put Humpty together again"
        };
        Random random=new Random();
        for(int i=0;i<messages.length;i++){
            message.write(messages[i]);
            try{
                Thread.sleep(random.nextInt(2000));
            }catch(InterruptedException e){
                System.out.println("WRITE INTERRUPTED");
            }
        }
        message.write("Finished");
    }
}

class Reader implements Runnable{
    private Message message;
    public Reader(Message message){
        this.message=message;
    }
    public void run(){
        Random random=new Random();
        for(String latestMessage=message.read();
            !latestMessage.equals("Finished");
            latestMessage=message.read()){

            System.out.println(latestMessage);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                System.out.println("READ INTERRUPTED");
            }
        }
    }
}