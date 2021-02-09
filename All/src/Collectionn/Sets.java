package Collectionn;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/*
    Collection
    Set
    SortedSet
    NavigableSet
 */
public class Sets {
    public static void main(String[] args) {
        HashSet<Integer> hashSet=new HashSet<>();
    }
}
class HashSetDemo {
    public static void main(String args[]) {
        HashSet<String> hs = new HashSet<String>();
        TreeSet<String> ts=new TreeSet<String>();
        hs.add("B");
        hs.add("A");
        hs.add("D");
        hs.add("E");
        hs.add("C");
        hs.add("F");
        ts.add("B");
        ts.add("A");
        ts.add("D");
        ts.add("E");
        ts.add("C");
        ts.add("F");
        LinkedHashSet<String> hsc=(LinkedHashSet<String>)hs.clone();
        System.out.println(ts);
        System.out.println(hs);
        System.out.println(hsc);
    }
}