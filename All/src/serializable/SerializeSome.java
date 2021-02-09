package serializable;

import java.io.*;
import java.util.*;

public class SerializeSome {
    //static ArrayList<Employee> employees = new ArrayList<>(), employees1 = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        ArrayList<Employee> employees = new ArrayList<>(), employees1 = new ArrayList<>();
        Employee firstEmp = new Employee("AAA");
        employees.add(firstEmp);
        employees.add(new Employee("CCC"));
        employees.add(new Employee("BBB"));

        FileOutputStream fout = new FileOutputStream("D:\\VCE\\OOP\\All\\src\\serializable\\Employee.txt");
        ObjectOutputStream out = new ObjectOutputStream(fout);
        for (Employee employee : employees)
            out.writeObject(employee);

        employees1.add(new Employee("DDD"));
        FileInputStream fin = new FileInputStream("D:\\VCE\\OOP\\All\\src\\serializable\\Employee.txt");
        ObjectInputStream in = new ObjectInputStream(fin);

        for (int i = 0; i < 3; i++)
            employees1.add((Employee) in.readObject());
        Employee anotherEmp = new Employee("Another");
        employees1.sort(anotherEmp);
        Collections.sort(employees);
        for (Employee d : employees1) {
            System.out.println(d.name);
        }
    }
}

class Employee implements Serializable, Comparator<Employee>, Comparable<Employee> {
    String name;

    Employee(String name) {
        this.name = name;
    }

    public int compare(Employee o1, Employee o2) {
        return o1.name.compareTo(o2.name);
    }

    public int compareTo(Employee o) {
        return 0;
    }
}