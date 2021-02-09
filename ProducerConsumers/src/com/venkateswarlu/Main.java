package com.venkateswarlu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import static com.venkateswarlu.Main.EOF;

public class Main {
    public static final String EOF="EOF";

    public static void main(String[] args) {
        List<String> buffer=new ArrayList<>();
        ReentrantLock bufferLock=new ReentrantLock();
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        MyProducer producer=new MyProducer(buffer, ThreadColor.ANSI_WHITE, bufferLock);
        MyConsumer consumer1=new MyConsumer(buffer, ThreadColor.ANSI_LIGHT_YELLOW, bufferLock);
        MyConsumer consumer2=new MyConsumer(buffer, ThreadColor.ANSI_GREEN, bufferLock);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);
        executorService.shutdown();
    }
}

class MyProducer implements Runnable{
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock){
        this.buffer=buffer;
        this.color=color;
        this.bufferLock=bufferLock;
    }
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};
        for (String num : nums) {
            try {
                System.out.println(color + "Adding..." + num);
                bufferLock.lock();
                try {
                    buffer.add(num);
                } finally {
                    bufferLock.unlock();
                }
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }
        System.out.println(color + "Adding EOF and exiting...");
        bufferLock.lock();
        try {
            buffer.add("EOF");
        } finally {
            bufferLock.unlock();
        }
    }
}

class MyConsumer implements Runnable{
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock=new ReentrantLock();

    public MyConsumer(List<String> buffer, String color,ReentrantLock bufferLock){
        this.buffer=buffer;
        this.color=color;
        this.bufferLock=bufferLock;
    }

    public void run() {
        while(true){
            bufferLock.lock();
            try {
                if (buffer.isEmpty()) {
                    continue;
                }
                if (buffer.get(0).equals("EOF")) {
                    System.out.println(color + "Exiting...");
                    break;
                } else {
                    System.out.println(color + "removed" + buffer.remove(0));
                }
            }finally {
                bufferLock.unlock();
            }
        }
    }
/*package com.venkateswarlu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static com.venkateswarlu.railwaystation.Main.EOF;

public class Main {
    public static final String EOF="EOF";

    public static void main(String[] args) {
        List<String> buffer=new ArrayList<>();
        ReentrantLock bufferLock=new ReentrantLock();
        MyProducer producer=new MyProducer(buffer, ThreadColor.ANSI_WHITE, bufferLock);
        MyConsumer consumer1=new MyConsumer(buffer, ThreadColor.ANSI_LIGHT_YELLOW, bufferLock);
        MyConsumer consumer2=new MyConsumer(buffer, ThreadColor.ANSI_GREEN, bufferLock);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }
}

class MyProducer implements Runnable{
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock){
        this.buffer=buffer;
        this.color=color;
        this.bufferLock=bufferLock;
    }
    public void run(){
        Random random=new Random();
        String[] nums={"1","2","3","4","5"};
        for(String num:nums){
            try{
                System.out.println(color+"Adding..."+num);
                bufferLock.lock();
                try{
                    buffer.add(num);
                }finally {
                    bufferLock.unlock();
                }
                Thread.sleep(random.nextInt(1000));
            }catch(InterruptedException e){
                System.out.println("Producer was interrupted");
            }
        }
        System.out.println(color+"Adding EOF and exiting...");
        bufferLock.lock();
        try{
            buffer.add("EOF");
        }finally {
            bufferLock.unlock();
        }
    }
    *//*public void run(){
        Random random=new Random();
        String[] nums={"1","2","3","4","5"};
        for(String num:nums){
            try{
                System.out.println(color+"Adding..."+num);
                bufferLock.lock();
                buffer.add(num);
                bufferLock.unlock();
                Thread.sleep(random.nextInt(1000));
            }catch(InterruptedException e){
                System.out.println("Producer was interrupted");
            }
        }
        System.out.println(color+"Adding EOF and exiting...");
        bufferLock.lock();
        buffer.add("EOF");
        bufferLock.unlock();
    }*//*
}

class MyConsumer implements Runnable{
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock=new ReentrantLock();

    public MyConsumer(List<String> buffer, String color,ReentrantLock bufferLock){
        this.buffer=buffer;
        this.color=color;
        this.bufferLock=bufferLock;
    }

   public void run() {
        while(true){
            bufferLock.lock();
            try {
                if (buffer.isEmpty()) {
                    continue;
                }
                if (buffer.get(0).equals(EOF)) {
                    System.out.println(color + "Exiting...");
                    break;
                } else {
                    System.out.println(color + "removed" + buffer.remove(0));
                }
            }finally {
                bufferLock.unlock();
            }
        }
    }*/

    /*public void run() {
        while(true){
            bufferLock.lock();
            if(buffer.isEmpty()){
                bufferLock.unlock();
                continue;
            }
            if(buffer.get(0).equals(EOF)){
                System.out.println(color+"Exiting...");
                bufferLock.unlock();
                break;
            }else{
                System.out.println(color+"removed"+buffer.remove(0));
            }
            bufferLock.unlock();
        }
    }*/
}

class ThreadColor {
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

/*
package com.venkateswarlu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.venkateswarlu.railwaystation.Main.EOF;

public class Main {
    public static final String EOF="EOF";

    public static void main(String[] args) {
        List<String> buffer=new ArrayList<>();
        MyProducer producer=new MyProducer(buffer, ThreadColor.ANSI_WHITE);
        MyConsumer consumer1=new MyConsumer(buffer, ThreadColor.ANSI_LIGHT_YELLOW);
        MyConsumer consumer2=new MyConsumer(buffer, ThreadColor.ANSI_GREEN);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }
}

class MyProducer implements Runnable{
    private List<String> buffer;
    private String color;

    public MyProducer(List<String> buffer, String color){
        this.buffer=buffer;
        this.color=color;
    }
    public void run(){
        Random random=new Random();
        String[] nums={"1","2","3","4","5"};
        for(String num:nums){
            try{
                System.out.println(color+"Adding..."+num);
                synchronized (buffer){
                    buffer.add(num);
                }
                Thread.sleep(random.nextInt(1000));
            }catch(InterruptedException e){
                System.out.println("Producer was interrupted");
            }
        }
        System.out.println(color+"Adding EOF and exiting...");
        synchronized (buffer){
            buffer.add("EOF");
        }
    }
}

class MyConsumer implements Runnable{
    private List<String> buffer;
    private String color;

    public MyConsumer(List<String> buffer, String color){
        this.buffer=buffer;
        this.color=color;
    }

    public void run() {
        while(true){
            synchronized (buffer){
                if(buffer.isEmpty()){
                    continue;
                }
                if(buffer.get(0).equals(EOF)){
                    System.out.println(color+"Exiting...");
                    break;
                }else{
                    System.out.println(color+"removed"+buffer.remove(0));
                }
            }
        }
    }
}

class ThreadColor {
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
}*/
