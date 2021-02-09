package com.venkateswarlu.set_eight;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter time slot : ");
        int t=scanner.nextInt();
        Relay relay = new Relay(t);

        new Thread(new One(relay)).start();
        new Thread(new Two(relay)).start();
        new Thread(new Three(relay)).start();
        new Thread(new Four(relay)).start();
    }
}


class Relay {
    private boolean[] semaphore={false, false, false, false};
    public static Relay relay=null;
    private int timeSlot;
    private int cnt=0;
    Relay(int timeSlot){
        this.timeSlot=timeSlot;
    }
    public synchronized void one(){
        while(semaphore[0]){
            try{
                wait();
            }catch(InterruptedException e) {
                System.out.println("First player isn't okie");
            }
        }
        int start=cnt;
        for(int i=0;i<4;i++) {
            System.out.print(" Thread "+(1+i)+" : " + ((start+i*5)%(4*5)));
        }
        System.out.println();
        cnt+=timeSlot;
        semaphore[0]=true;
        notifyAll();
    }
    public synchronized void two(){
        while(!semaphore[0]&&!semaphore[1]){
            try{
                wait();
            }catch(InterruptedException e) {
                System.out.println("second player isn't okie");
            }
        }
        System.out.println("After : "+cnt);
        int start=cnt;
        for(int i=0;i<4;i++) {
            System.out.print(" Thread "+(1+i)+" : " + ((start+i*5)%(4*5)));
        }
        System.out.println();
        cnt+=timeSlot;
        semaphore[1]=true;
        notifyAll();
    }
    public synchronized void three(){
        while(!semaphore[1]&&!semaphore[2]){
            try{
                wait();
            }catch(InterruptedException e) {
                System.out.println("third player isn't okie");
            }
        }
        System.out.println("After : "+cnt);
        int start=cnt;
        for(int i=0;i<4;i++) {
            System.out.print(" Thread "+(i+1)+" : " + ((start+i*5)%(4*5)));
        }        semaphore[2]=true;
        System.out.println();
        cnt+=timeSlot;
        notifyAll();
    }
    public synchronized void fourth() {
        while (!semaphore[2]&&!semaphore[3]) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("fourth player isn't okie");
            }
        }
        System.out.println("After : "+cnt);
        int start=cnt;
        for(int i=0;i<4;i++) {
            System.out.print(" Thread "+(i+1)+" : " + ((start+i*5)%(4*5)));
        }        semaphore[3] = true;
        System.out.println();
        cnt+=timeSlot;
        semaphore[0]=false;
        semaphore[1]=false;
        semaphore[2]=false;
        semaphore[3]=false;
        notifyAll();
    }
}
class One implements Runnable{
    Relay relay;
    One(Relay relay){
        this.relay=relay;
    }
    public void run(){
        relay.one();
    }
}
class Two implements Runnable{
    Relay relay;
    Two(Relay relay){
        this.relay=relay;
    }
    public void run(){
        relay.two();
    }
}
class Three implements Runnable{
    Relay relay;
    Three(Relay relay){
        this.relay=relay;
    }
    public void run(){
        relay.three();
    }
}
class Four implements Runnable {
    Relay relay;

    Four(Relay relay) {
        this.relay = relay;
    }

    public void run() {
        relay.fourth();
    }
}
