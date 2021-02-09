package vector;

import java.util.Vector;

public class VectorDemo{
    public static void main(String[] args) {
        Vector<Integer> v=new Vector<>(2, 1);
        System.out.println("Initial capacity : "+v.capacity());
        v.add(10);
        v.addElement(100);
        System.out.println("Capacity after full : "+v.capacity());
        v.add(0,1000);
        System.out.println("Capacity after adding : "+v.capacity());
        System.out.println(v);
    }
}