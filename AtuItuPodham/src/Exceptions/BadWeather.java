package Exceptions;

public class BadWeather extends Exception{
    String exceptionName;
    public BadWeather(String exceptionName){
        super(exceptionName);
        this.exceptionName=exceptionName;
    }
    public String toString() {
        return this.exceptionName;
    }
}
