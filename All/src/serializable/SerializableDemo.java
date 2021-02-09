package serializable;

import java.io.*;

public class SerializableDemo {
    public static void main(String[] args) throws Exception {
        Student venkateswarlu=new Student((byte)119, "Venkateswarlu Gupta", "Computer Science");
        FileOutputStream fout=new FileOutputStream("D:\\VCE\\OOP\\All\\src\\serializable\\SerializedObject.txt");
        ObjectOutputStream out=new ObjectOutputStream(fout);
        out.writeObject(venkateswarlu);
        out.close();
        fout.close();
        System.out.format("Serialization of %s is successful",venkateswarlu.name);
    }
}
class DeserializableDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student venkateswarlu=null;
        float pai=(float) 3.141526;
        try{
            FileInputStream fin=new FileInputStream("D:\\VCE\\OOP\\All\\src\\serializable\\SerializedObject.txt");
            ObjectInputStream in=new ObjectInputStream(fin);
            venkateswarlu=(Student) in.readObject();
            in.close();
            fin.close();
        }finally {
            assert venkateswarlu != null;
            System.out.format("Student name : %s\nStudent roll no : %d\nStudent branch : %s",
                            venkateswarlu.name,venkateswarlu.roll,venkateswarlu.branch);
            System.out.format("Value of pai upto 5 decimal digits is %.5f",pai);
        }
    }
}
class Student implements Serializable, Runnable{
    byte roll;
    String name;
    String branch;
    Student(byte roll, String name, String branch){
        this.roll=roll;
        this.name=name;
        this.branch=branch;
    }

    @Override
    public void run() {
        System.out.println("Thread running");
    }
}


class SerializeThread {
    public static void main(String[] args) throws Exception {
        Student venkateswarlu=new Student((byte)119, "Venkateswarlu Gupta", "Computer Science");
        FileOutputStream fout=new FileOutputStream("D:\\VCE\\OOP\\All\\src\\serializable\\Serializethread.txt");
        ObjectOutputStream out=new ObjectOutputStream(fout);
        out.writeObject(venkateswarlu);
        out.close();
        fout.close();
        System.out.format("Serialization of %s is successful",venkateswarlu.name);
    }
}
class DeserializeThread {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student venkateswarlu=null;
        float pai=(float) 3.141526;
        try{
            FileInputStream fin=new FileInputStream("D:\\VCE\\OOP\\All\\src\\serializable\\Serializethread.txt");
            ObjectInputStream in=new ObjectInputStream(fin);
            venkateswarlu=(Student) in.readObject();
            in.close();
            fin.close();
        }finally {
            assert venkateswarlu != null;
            System.out.format("Student name : %s\nStudent roll no : %d\nStudent branch : %s",
                    venkateswarlu.name,venkateswarlu.roll,venkateswarlu.branch);
            System.out.format("Value of pai upto 5 decimal digits is %.5f",pai);
        }
    }
}