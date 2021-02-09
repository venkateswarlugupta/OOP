package timertask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskDemo {
    public static Timer timer = new Timer();
    public static TimerTask task;
    public static Calendar date=new GregorianCalendar();

    public static void main(String[] args) throws IOException {
        System.out.println("Start of the program");
        task=new TimerTask() {
            public void run() {
                System.out.println(date.getTime());
                //timer.cancel();
            }
        };
        System.out.println(date.getTime());
        date.add(Calendar.SECOND,5);
        timer.schedule(task, date.getTime(),5000);
        System.out.print("Enter zero to procrastinate : ");
        int option=Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        if (option == 0) {
            timer.cancel();
            reset();
        }
    }
    public static void reset(){
        timer=new Timer();
        date.add(Calendar.SECOND,30);
        task=new TimerTask() {
            public void run() {
                System.out.println(date.getTime());
                //timer.cancel();
            }
        };
        timer.schedule(task,date.getTime(),5000);
    }
}

class MultipleTimerTasks{
    public static Timer t1,t2,t3;
    public static TimerTask tt1,tt2,tt3;
    public static void main(String[] args) {
        createTask("ROYAL", t1, tt1, 1000);
        createTask("CHALLENGERS", t2, tt2, 5000);
        createTask("BENGALURU", t3, tt3, 10000);
    }
    private static void createTask(String s,Timer t, TimerTask tt, int delay){
        t=new Timer();
        Timer finalT = t;
        tt=new TimerTask() {
            @Override
            public void run() {
                System.out.println(s+" "+new GregorianCalendar().getTime());
                finalT.cancel();
            }
        };



        t.schedule(tt,delay);
    }
}

class Lively{
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

    public static void main(String[] args) {
        System.out.println(ANSI_GREEN+"ANSI_GREEN");
        System.out.println(ANSI_BLACK+"ANSI_BLACK");
        System.out.println(ANSI_RED+"ANSI_RED");
        System.out.println(ANSI_RESET+"ANSI_RESET"+ANSI_LIGHT_YELLOW);
        System.out.println("ANSI_LIGHT_YELLOW");
        System.out.println(ANSI_YELLOW+"ANSI_YELLOW");
        System.out.println(ANSI_BLUE+"ANSI_BLUE");
        System.out.println(ANSI_CYAN+"ANSI_CYAN");
        System.out.println(ANSI_WHITE+"ANSI_WHITE");
        System.out.println(ANSI_PURPLE+"ANSI_PURPLE");
    }
}


