package Holidays;
class Main{
    public static void  main(String... args){
        try {
            System.out.println("venkateswarlu");
            throw new NosuchException();
        }catch(Exception e){
            System.out.println("No Such Exception handled");
        }
    }
}
class NosuchException extends Exception{
    NosuchException(){
        //
    }
}