import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*interface Factorial{
    String factorial(int n);
}
class CalculateFactorial {
    public static void main(String[] args) {
        Factorial fact=(5)->{
            return "120";
        };
    }
    static int f(Factorial fact, int n){
        fact
    }
}*/
class CodeToRun implements Runnable {

    @Override
    public void run() {
        System.out.println("Printing from runnable");
    }
}

public class Main {
    public static void main(String[] args) {
        //new Thread(new CodeToRun()).start();

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Printing from runnable");
            }
        }).start();*/

        //new Thread(()-> System.out.println("Lambda Printing from runnable")).start();

/*
        new Thread(()-> {
            System.out.println("Lambda Printing from runnable");
            System.out.println("2nd line ");
            System.out.format("line no %d\n",3);
        }).start();
*/

        Student venkatesh=new Student("Venkatesh",119);
        Student ramakanth=new Student("Ramakanth",118);
        Student bala=new Student("Bala Krishna",10);
        Student tharun=new Student("Sai Tharun",110);
        List<Student> students=new ArrayList<>();
        students.add(venkatesh);
        students.add(ramakanth);
        students.add(bala);
        students.add(tharun);

//        Collections.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student student1, Student student2) {
//                return student1.getName().compareTo(student2.getName());
//            }
//        });

        Collections.sort(students, (Student student1, Student student2) ->
                            student1.getName().compareTo(student2.getName()));

        Collections.sort(students, (student1, student2) ->
                student1.getName().compareTo(student2.getName()));

        for(Student student:students){
            System.out.println(student.getName());
        }

        /*String sillyString=doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                return s1.toUpperCase()+" "+s2.toUpperCase();
            }
        }, students.get(0).getName(),students.get(1).getName());

        System.out.println(sillyString);*/

        //UpperConcat uc=(s1,s2) -> s1.toUpperCase()+" "+s2.toUpperCase();
        UpperConcat uc=(s1,s2) -> {
            String result=s1.toUpperCase() + " " + s2.toUpperCase();
            return result;
        };
        String sillyString=doStringStuff(uc, students.get(0).getName(),students.get(3).getName());
        System.out.println(sillyString);
    }

    public final static String doStringStuff(UpperConcat uc, String s1,String s2){
        return uc.upperAndConcat(s1,s2);
    }
}

interface UpperConcat{
    public String upperAndConcat(String s1, String s2);
}


class AnotherClass{
    public String doSomething(){
        UpperConcat uc=(s1,s2)->{
            System.out.println("The lambda expression's class is "+getClass().getSimpleName());
            String result=s1.toUpperCase()+" "+s2.toUpperCase();
            return result;
        };

        System.out.println("The Another class's name is "+getClass().getSimpleName());
        return Main.doStringStuff(uc,"String1", "String2");
//        System.out.println("The another class name : "+getClass().getSimpleName());
//        return Main.doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("Anonymous class name : "+
//                        getClass().getSimpleName());
//                return s1.toUpperCase()+" "+s2.toUpperCase();
//            };
//        }, "String1", "String2");
    }
}
final class Mumbai extends Maharashtra{
    /*static{
        System.out.println("Mumbai");
    }*/
    Mumbai(){
        System.out.println("Child constructor is called");
    }

    void me(){
        super.me();
        //System.out.println("City");
    }
}
class Maharashtra{
    /*static {
        System.out.println("Maharashtra");
    }*/
    Maharashtra(){
        System.out.println("Parent constructor is called");
    }
    void me(){
        System.out.println("State");
    }
}
class Nothing{
    public static void main(String[] args) {
        Mumbai mumbai=new Mumbai();
        mumbai.me();
        new Maharashtra().me();
    }
}
class Student {
    private String name;
    private int rollNumber;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }
}