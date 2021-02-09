package protected1;

public class ProtectedDemo {
    protected String name;
    protected String job;

    protected ProtectedDemo(String name, String job){
        this.name=name;
        this.job=job;
    }

    protected void display(){
        System.out.format("Name : %s\nJob  : %s",name,job);
    }
}

class Student extends ProtectedDemo{

    protected Student(String name, String job) {
        super(name, job);
    }

    public static void main(String[] args) {
        Student student=new Student("venktesh","Student");
        student.display();
    }
}