package Exceptions;

public class IWontSay extends Exception{
    public IWontSay(){
        //
    }
    public String toString(){
        return "vaadu cheppadu antaaa!";
    }
}

class Main{
    public static void main(String[] args) {
        try{
            throw new IWontSay();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}