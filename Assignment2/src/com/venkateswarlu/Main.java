package com.venkateswarlu;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        /*Transactions transactions=Transactions.getInstance();
        new Thread(new Father(new Entry("Deposit",1000))).start();
        new Thread(new Roommate(new Entry("Withdraw", 550))).start();
        new Thread(new Father(new Entry("Deposit",1000))).start();
        new Thread(new Son()).start();*/
        new Thread(){
            public void run(){
                System.out.println("Thread running");
            }
        }.start();
/*        new Fuck(){
            void Fucking(){
                System.out.println("Fuckoff");
            }
        };*/
    }
}
class Entry{
    private String type;
    private double amount;
    public Entry(String type, double amount){
        this.amount=amount;
        this.type=type;
    }
    public String getType(){
        return type;
    }
    public double getAmount(){
        return amount;
    }
}
class Transactions{
    private Entry entry;
    private static ArrayList<Entry> entries=null;
    static Transactions transactions;
    private Transactions(){
        entries=new ArrayList<>();
    }
    public static Transactions getInstance(){
        if(entries==null){
            transactions = new Transactions();
        }
        return transactions;
    }
    public synchronized double addTransactions(Entry entry){
        System.out.println(entry.getAmount()+" is "+entry.getType()+"ing...");
        entries.add(entry);
        return entry.getAmount();
    }
    public synchronized double displayBalance(){
        double bal=0;
        for(int i=0;i<entries.size();i++){
            Entry entry=entries.get(i);
            if(entry.getType().equals("Withdraw")){
                bal-=entry.getAmount();
            }else{
                bal+=entry.getAmount();
            }
        }
        return bal;
    }
}
class Father implements Runnable{// adds
    Entry entry;
    Transactions transactions=Transactions.getInstance();
    Father(Entry initialEntry){
        this.entry=initialEntry;
    }
    public void run(){
        transactions.addTransactions(entry);
    }
}
class Son implements Runnable{ // display
    Transactions transactions=Transactions.getInstance();
    Son(){
        //
    }
    public void run(){
        System.out.println("Current balance is : "+transactions.displayBalance());
    }
}
class Roommate implements Runnable{
    Entry entry;
    Transactions transactions=Transactions.getInstance();
    Roommate(Entry initialEntry){
        this.entry=initialEntry;
    }
    public void run(){
        transactions.addTransactions(entry);
    }
}