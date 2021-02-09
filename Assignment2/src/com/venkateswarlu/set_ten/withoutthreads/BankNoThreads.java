package com.venkateswarlu.set_ten.withoutthreads;

import java.util.ArrayList;

public class BankNoThreads {
    public static void main(String[] args) {
        Usecase usecase=new Usecase(new Entry("Deposit",1000));
        usecase.addTransaction(new Entry("Withdraw",5500));
        System.out.println("balance is : "+usecase.getBalance());
    }
}

class Usecase{
    private ArrayList<Entry> transactions;
    private double balance;

    Usecase(Entry entry){
        balance=0;
        this.transactions=new ArrayList<>();
        addTransaction(entry);
    }

    public void addTransaction(Entry entry){
        if(entry.getType().equals("Withdraw")){
            double bal=getBalance();
            if(entry.getAmount()<=bal){
                this.transactions.add(entry);
            }else{
                System.out.println("Insufficient balance to withdraw");
                System.out.println("Current balance is :"+bal);
            }
        }else{
            this.transactions.add(entry);
        }
    }

    public double getBalance(){//display
        balance=0;
        for(int i=0;i<transactions.size();i++){
            Entry eachTransaction=transactions.get(i);
            if(eachTransaction.getType().equals("Withdraw"))
                balance-=eachTransaction.getAmount();
            else
                balance+=eachTransaction.getAmount();
        }
        return balance;
    }
}
class Entry{
    private String type;
    private double amount;

    Entry(String type, double amount){
        this.type=type;
        this.amount=amount;
    }

    public String getType(){
        return type;
    }

    public double getAmount(){
        return amount;
    }
}