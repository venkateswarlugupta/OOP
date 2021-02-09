package Exceptions;

public class FoodException extends Exception{
    public FoodException(){
        //
    }
    public String toString(){
        return "Food baale";
    }
}

class TestMain{
    public static void main(String[] args) {
        try{
            throw new FoodException();
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}