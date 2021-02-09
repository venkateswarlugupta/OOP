import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class StrTokenizer {
    public static void main(String... args) {

        StringTokenizer stringTokenizer = new StringTokenizer("Vankadari:;Venkateswarlu;Gupta;cs", ":;", true);
        System.out.println("No of tokens left :" + stringTokenizer.countTokens());
        while (stringTokenizer.hasMoreTokens()) {
            System.out.println("     " + stringTokenizer.nextToken());
            System.out.println("No of tokens left :" + stringTokenizer.countTokens());
        }
    }
}

class DateDemo {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        long msec = date.getTime();
        System.out.println("Milliseconds since Jan. 1, 1970 GMT = " + msec);
    }
}

class CalendarDemo {
    public static void main(String[] args) {
        String[] months = {
                "Jan", "Feb", "Mar", "Apr",
                "May", "Jun", "Jul", "Aug",
                "Sep", "Oct", "Nov", "Dec"};
// Create a calendar initialized with the
// current date and time in the default
// locale and timezone.
        Calendar calendar = Calendar.getInstance();
// Display current time and date information.
        System.out.print("Date: ");
        System.out.print(months[calendar.get(Calendar.MONTH)]);
        System.out.print(" " + calendar.get(Calendar.DATE) + " ");
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.print("Time: ");
        System.out.print(calendar.get(Calendar.HOUR) + ":");
        System.out.print(calendar.get(Calendar.MINUTE) + ":");
        System.out.println(calendar.get(Calendar.SECOND));
// Set the time and date information and display it.
        calendar.set(Calendar.HOUR, 10);
        calendar.set(Calendar.MINUTE, 29);
        calendar.set(Calendar.SECOND, 22);
        System.out.print("Updated time: ");
        System.out.print(calendar.get(Calendar.HOUR) + ":");
        System.out.print(calendar.get(Calendar.MINUTE) + ":");
        System.out.println(calendar.get(Calendar.SECOND));
        Calendar calendar1 = (Calendar) calendar.clone();
        calendar1.set(2000, Calendar.DECEMBER, 31);
        System.out.print("My Birthday : " + calendar1.get(Calendar.YEAR));
        System.out.print(" " + months[calendar1.get(Calendar.MONTH)]);
        System.out.print(" " + calendar1.get(Calendar.DATE) + " ");

        System.out.print("Date: ");
        System.out.print(months[calendar.get(Calendar.MONTH)]);
        System.out.print(" " + calendar.get(Calendar.DATE) + " ");
        System.out.println(calendar.get(Calendar.YEAR));

    }
}

class GregorianCalendarDemo {
    public static void main(String[] args) {
        String[] months = {
                "Jan", "Feb", "Mar", "Apr",
                "May", "Jun", "Jul", "Aug",
                "Sep", "Oct", "Nov", "Dec"};
        int year;
// Create a Gregorian calendar initialized
// with the current date and time in the
// default locale and timezone.
        GregorianCalendar gcalendar = new GregorianCalendar();
// Display current time and date information.
        System.out.print("Date: ");
        System.out.print(months[gcalendar.get(Calendar.MONTH)]);
        System.out.print(" " + gcalendar.get(Calendar.DATE) + " ");
        System.out.println(year = gcalendar.get(Calendar.YEAR));
        System.out.print("Time: ");
        System.out.print(gcalendar.get(Calendar.HOUR) + ":");
        System.out.print(gcalendar.get(Calendar.MINUTE) + ":");
        System.out.println(gcalendar.get(Calendar.SECOND));
// Test if the current year is a leap year
        if (gcalendar.isLeapYear(year)) {
            System.out.format("%s is a leap year", gcalendar.get(Calendar.YEAR));
        } else {
            System.out.format("%s is not a leap year", gcalendar.get(Calendar.YEAR));
        }
    }
}

class Randomm {
    public static void main(String args[]) {
        Random r = new Random();
        double val;
        double sum = 0;
        int bell[] = new int[10];
        for (int i = 0; i < 100; i++) {
            val = r.nextGaussian();
            sum += val;
            double t = -2;
            for (int x = 0; x < 10; x++, t += 0.5)
                if (val < t) {
                    bell[x]++;
                    break;
                }
        }
        System.out.println("Average of values: " +
                (sum / 100));
// display bell curve, sideways
        for (int i = 0; i < 10; i++) {
            System.out.print(bell[i] + ' ' + " ");
            for (int x = bell[i]; x > 0; x--)
                System.out.print("*");
            System.out.println();
        }
    }
}

//class MyTimer extends TimerTask {
//    public void run() {
//        System.out.println("Timer task executed.");
//        try {
//            Runtime.getRuntime().exec("notepad.exe");
//        } catch (IOException e) {
//            e.printStackTrace();
//        /*try {
//            Runtime.getRuntime().exec("C:\\Users\\sudda\\Desktop\\myfirstbatfile.bat");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }*/
//        }
//    }
//    class TimerDemo {
//        public static void main(String args[]) {
//            MyTimer myTask = new MyTimer();
//            Timer myTimer = new Timer();
//            myTimer.schedule(myTask, 1000, 500);
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException exc) {
//                exc.printStackTrace();
//            }
//            myTimer.cancel();
//        }
//    }
//}

class MyTimer extends TimerTask {
    public void run() {
        System.out.println("Timer task executed.");
        try {
            Runtime.getRuntime().exec("notepad.exe");
        } catch (IOException e) { //
            try {
                System.out.println("");
                //Runtime.getRuntime().exec("C:\\Users\\sudda\\Desktop\\myfirstbatfile.bat");
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
    }
}
class Demotimer {
    public static void main(String args[]) {
        MyTimer myTask = new MyTimer();
        Timer myTimer = new Timer();
        myTimer.schedule(myTask, 1000, 500);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }
        myTimer.cancel();
    }
}

class Watcher implements Observer {
    public void update(Observable obj, Object arg) {
        System.out.println("update() called, count is " +
                ((Integer)arg).intValue());
    }
}

class BeingWatched extends Observable {
    void counter(int period) {
        for( ; period >=0; period--) {
            setChanged();
            notifyObservers(new Integer(period));
            try {
                Thread.sleep(100);
            } catch(InterruptedException e) {
                System.out.println("Sleep interrupted");
            }
        }
    }
}
class ObserverDemo {
    public static void main(String args[]) {
        BeingWatched observed = new BeingWatched();
        Watcher observing = new Watcher();
/* Add the observing to the list of observers for
observed object. */
        observed.addObserver(observing);
        observed.counter(10);
    }
}


class Watcher1 implements Observer {
    public void update(Observable obj, Object arg) {
        System.out.println("update() called, count is " +
                ((Integer)arg).intValue());
    }
}
// This is the second observing class.
class Watcher2 implements Observer {
    public void update(Observable obj, Object arg) {
// Ring bell when done
        if(((Integer)arg).intValue() == 0)
            System.out.println("Done" + '\7');
        try {
            Runtime.getRuntime().exec("notepad.exe");
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
}
class TwoObservers {
    public static void main(String args[]) {
        BeingWatched observed = new BeingWatched();
        Watcher1 observing1 = new Watcher1();
        Watcher2 observing2 = new Watcher2();
// add both observers
        observed.addObserver(observing1);
        observed.addObserver(observing2);
        observed.counter(6);
    }
}

class LetsOpenNotepad{
    public static void main(String[] args) throws Exception {
        FileWriter fw=new FileWriter("D:\\VCE\\OOP\\IO.3.O\\src\\character_stream\\spod.txt");
        fw.write("hello");
        //String obj="cd D:\\V CE\\OOP\\IO.3.O\\src\\character_stream"+'\n'+"D:"+"\n"+"spod.txt";
        String obj="cd D:\\VCE\\OOP\\IO.3.O\\src\\character_stream\nD:\nspod.txt";
        FileWriter fwb=new FileWriter("D:\\VCE\\OOP\\IO.3.O\\src\\character_stream\\batchhh.bat");
        fwb.write(obj);
        fwb.flush();
        fw.flush();
        fwb.close();
        fw.close();
        try {

            Runtime.getRuntime().exec("D:\\VCE\\OOP\\IO.3.O\\src\\character_stream\\batchhh.bat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Mainn{
    public static void main(String[] args) {
        Squares xPowerTwo=new Squares();
        xPowerTwo.addSquares(1);
        xPowerTwo.addSquares(2);
        xPowerTwo.addSquares(3);
        System.out.println(xPowerTwo);
        xPowerTwo.printListOfSquares();
        System.out.println(xPowerTwo);
        xPowerTwo.addSquares(4);
        xPowerTwo.addSquares(5);
        System.out.println(xPowerTwo);
        xPowerTwo.printListOfSquares();
        System.out.println(xPowerTwo);
    }
}
class Squares{
    ArrayList<Integer> squares;
    Squares(){
        squares=new ArrayList<>();
    }
    void addSquares(int sq){
        squares.add(sq*sq);
    }
    void printListOfSquares(){
        for(int square:squares){
            System.out.print(square+" ");
        }
        System.out.println();
    }
}

class RegExp{
    public static void main(String[] args) {
        Pattern lowerAlphabet=Pattern.compile("[a-z]");
        Pattern lowerAlphabets=Pattern.compile("[a-z]+");
        Pattern upperAlphabet=Pattern.compile("[A-Z]");
        Pattern digit=Pattern.compile("[\\d]");
        System.out.println(digit.matcher("6300636693"));
        System.out.println(lowerAlphabets.matcher("abcdef123"));
        /*System.out.println(lowerAlphabets.matcher("abcdef123").start());
        System.out.println(lowerAlphabets.matcher("abcdef123").end());*/
        //System.out.println("31venks@gmail.com".pattern());

    }
}