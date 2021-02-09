package date_calender;

import java.time.LocalDate;

class Main{
    public static void main(String[] args) {
        LocalDate date=LocalDate.now();
        System.out.println(date);
        /*Calendar c=new GregorianCalendar();
        System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONTH));
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        System.out.println(c.get(Calendar.MINUTE));
        System.out.println(c.getTime());
        //c.set(2020,5,5);
        System.out.println(c.getTime());
        //c.add(Calendar.MONTH, 13);
        c.roll(Calendar.MONTH, 13);
        System.out.println(c.getTime());*/
    }
}
        //Date d=new Date(0,0,0);
        //System.out.println(d);
        /*double seconds = d.getTime()/1000;
        double minutes = seconds/60;
        double hours = minutes/60;
        double days = hours/24;
        double months = days/30;
        //double years = months/12;
        double years = days/365;/
        System.out.println(years);*/