import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Option> options=new ArrayList<>();
        Option op1,op2,op3;
        options.add(op1=new Option("FirstOption"));
        options.add(op2=new Option("SecondOption"));
        options.add(op3=new Option("ThirdOption"));
        Question question=new Question("FirstQuestion",(byte)4,options);
        question.displayQuestion();
        question.displayOptions();
        question.markOption(op1);
        question.markOption(op2);
        question.markOption(op2);
        question.markOption(op2);
        question.markOption(op1);
        question.finalScore();
    }
}
class Student{
    int roll;
    String name;
    Student(int roll, String name){
        this.roll=roll;
        this.name=name;
    }
}
class M{
    public static void main(String[] args) {
        ArrayList<Student> students=new ArrayList<>();
        students.add(new Student(119,"venkatesh"));
        students.add(new Student(119,"venki"));
        students.add(new Student(119,"venky"));
        System.out.println(students.get(1));
        System.out.println(students.get(2));
        System.out.println(students.get(0));
        System.out.println(students.indexOf(new Student(119,"venkatesh")));
    }
}
