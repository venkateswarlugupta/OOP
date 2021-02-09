package com.venkateswarlu.set_five;

import java.util.ArrayList;

public class MovieBooking {
    public static void main(String[] args) {
        Seat seat1=new Seat('A',(short)6);
        Seat seat2=new Seat('A',(short)7);
        (new Thread(new User(seat1))).start();
        (new Thread(new User(new Seat('A',(short)7)))).start();
        (new Thread(new User(new Seat('A',(short)8)))).start();
    }
}
class Seat{
    private char row;
    private short col;
    private boolean booked=false;
    public Seat(char row, short col){
        this.row=row;
        this.col=col;
    }
    public synchronized boolean booking(Seat seat){
        if(!booked){
            System.out.println( "Booked your tickets\n"+
                                "row : "+row+
                                " col : "+col);
            booked=true;
            return true;
        }else{
            System.out.println("Already booked");
            return false;
        }
    }
}
class User implements Runnable{
    private Seat seat;
    User(Seat seat){
        this.seat=seat;
    }
    public void run(){
        seat.booking(seat);
        seat.booking(seat);
    }

}
class Theater implements Runnable{
    private String theaterName;
    Theater(String theaterName){
        this.theaterName=theaterName;
    }
    Seat[][] hall=new Seat[4][4];
    public void run(){
        class User implements Runnable{
            private String userName;
            private Seat seat;
            User(String userName,Seat seat){
                this.seat=seat;
                this.userName=userName;
            }
            public void run(){
                seat.booking(seat);
            }
        }
    }
}