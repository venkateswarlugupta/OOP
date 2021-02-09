package Exceptions;

public class AirlineException extends Exception{
    String exceptionName;
    public AirlineException(String exceptionName){
        super(exceptionName);
        this.exceptionName=exceptionName;
    }
    public String toString() {
        return this.exceptionName;
    }
}