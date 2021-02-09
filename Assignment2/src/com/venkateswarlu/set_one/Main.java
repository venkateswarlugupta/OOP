package com.venkateswarlu.set_one;

public class Main {

    public static void main(String[] args) {
        Relay relay=new Relay();
        Relay relay2=new Relay();
        Relay relay3=new Relay();
        Relay relay4=new Relay();
        new Thread(new One(relay,ThreadColors.ANSI_GREEN)).start();
        new Thread(new Two(relay,ThreadColors.ANSI_GREEN)).start();
        new Thread(new Three(relay,ThreadColors.ANSI_GREEN)).start();
        new Thread(new Four(relay,ThreadColors.ANSI_GREEN)).start();
        new Thread(new One(relay2, ThreadColors.ANSI_RED)).start();
        new Thread(new Two(relay2, ThreadColors.ANSI_RED)).start();
        new Thread(new Three(relay2, ThreadColors.ANSI_RED)).start();
        new Thread(new Four(relay2, ThreadColors.ANSI_RED)).start();
        new Thread(new One(relay3,ThreadColors.ANSI_CYAN)).start();
        new Thread(new Two(relay3,ThreadColors.ANSI_CYAN)).start();
        new Thread(new Three(relay3,ThreadColors.ANSI_CYAN)).start();
        new Thread(new Four(relay3,ThreadColors.ANSI_CYAN)).start();
        new Thread(new One(relay4, ThreadColors.ANSI_YELLOW)).start();
        new Thread(new Two(relay4, ThreadColors.ANSI_YELLOW)).start();
        new Thread(new Three(relay4, ThreadColors.ANSI_YELLOW)).start();
        new Thread(new Four(relay4, ThreadColors.ANSI_YELLOW)).start();
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

class Relay {
    private boolean[] semaphore={false, false, false, false};
    public static Relay relay=null;
    Relay(){
        //
    }
    public synchronized void one(String color){
        while(semaphore[0]){
            try{
                wait();
            }catch(InterruptedException e) {
                System.out.println(color+"First player isn't okie");
            }
        }
        System.out.println(color+"One is running");
        semaphore[0]=true;
        notifyAll();
    }
    public synchronized void two(String color){
        while(!semaphore[0]&&!semaphore[1]){
            try{
                wait();
            }catch(InterruptedException e) {
                System.out.println(color+"second player isn't okie");
            }
        }
        System.out.println(color+"Two is running");
        semaphore[1]=true;
        notifyAll();
    }
    public synchronized void three(String color){
        while(!semaphore[1]&&!semaphore[2]){
            try{
                wait();
            }catch(InterruptedException e) {
                System.out.println(color+"third player isn't okie");
            }
        }
        System.out.println(color+"Third is running");
        semaphore[2]=true;
        notifyAll();
    }
    public synchronized void fourth(String color) {
        while (!semaphore[2]&&!semaphore[3]) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(color+"fourth player isn't okie");
            }
        }
        System.out.println(color+"Fourth is running");
        semaphore[3] = true;
        notifyAll();
    }
}

class Players implements Runnable{
    Relay relay;
    String color;
    Players(){
        //
    }
    Players(Relay relay, String color){
        this.relay=relay;
        this.color=color;
    }
    public void run(){
        relay.one(color);
    }
}
/*
class One extends Players{
    One(Relay relay, String color){
        super(relay, color);
    }
}
class Two extends Players{
    Two(Relay relay, String color){
        super(relay, color);
    }
}
class Three extends Players{
    Three(Relay relay, String color){
        super(relay, color);
    }
}
class Four extends Players{
    Four(Relay relay, String color){
        super(relay, color);
    }
}*/
class One implements Runnable{
    Relay relay;
    String color;
    One(Relay relay, String color){
        this.relay=relay;
        this.color=color;
    }
    public void run(){
        relay.one(color);
    }
}
class Two implements Runnable{
    Relay relay;
    String color;
    Two(Relay relay, String color){
        this.relay=relay;
        this.color=color;
    }
    public void run(){
        relay.two(color);
    }
}
class Three implements Runnable{
    Relay relay;
    String color;
    Three(Relay relay, String color){
        this.relay=relay;
        this.color=color;
    }
    public void run(){
        relay.three(color);
    }
}
class Four implements Runnable {
    Relay relay;
    String color;

    Four(Relay relay, String color) {
        this.relay = relay;
        this.color = color;
    }

    public void run() {
        relay.fourth(color);
    }
}