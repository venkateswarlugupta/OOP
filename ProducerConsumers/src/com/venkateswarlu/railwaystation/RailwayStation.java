package com.venkateswarlu.railwaystation;



class Main {

    public static void main(String[] args) {
        boolean isTrackAvailable=true;
        String trackName;
        Track platformOne=new Track("Platform-One", isTrackAvailable, ThreadColor.ANSI_WHITE);
        Train trainOne=new Train("TrainOne", isTrackAvailable, ThreadColor.ANSI_LIGHT_YELLOW);
        Train trainTwo=new Train("TrainTwo", isTrackAvailable, ThreadColor.ANSI_GREEN);

        new Thread(platformOne).start();
        new Thread(trainOne).start();
        new Thread(trainTwo).start();
    }
}

class Track implements Runnable{
    private String color;
    private String trackName;
    private boolean isTrackAvailable;
    public Track(String trackName, boolean isTrackAvailable, String color){
        this.trackName=trackName;
        this.isTrackAvailable=isTrackAvailable;
        this.color=color;
    }
    public void run(){
        try{
            System.out.println("ON PLATFORM ONE");
            Thread.sleep(2000);
        }catch (InterruptedException e){
            System.out.println(trackName + " UNDER MAINTAINENCE ");
        }
    }
}

class Train implements Runnable{
    private String trainName;
    private String color;
    private boolean isTrackAvailable;
    public Train(String trainName, boolean isTrackAvailable, String color){
        this.trainName=trainName;
        this.color=color;
        this.isTrackAvailable=isTrackAvailable;
    }

    public synchronized void run() {
        System.out.println(color+trainName+"came");
        System.out.println(color+trainName+"halted");
        System.out.println(color+trainName+"departed");

    }
}

class ThreadColor {
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