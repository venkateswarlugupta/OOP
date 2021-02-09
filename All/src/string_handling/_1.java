package string_handling;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class _1 {
    public static void main(String[] args) {
        byte[] arr={65,66,67};
        String byteStr=new String(arr);
        System.out.println(byteStr);
        //Character Extraction
        System.out.println("aeiou".charAt(2));
        String s="Venkateswarlu"+'\uFFFF';
        char[] chars=new char[s.length()];
        s.getChars(2,s.length(),chars, 0);
        System.out.println(chars);
        char[] letters={'a','b','c'};
        System.out.println(letters);
        //int[] ints={1,2,3};
        //System.out.println(Arrays.toString(ints));
        byte[] bytes=new byte[s.length()*2];
        System.out.println(Arrays.toString(s.getBytes(StandardCharsets.UTF_8)));
        char[] chars1;
        chars1=s.toCharArray();
        System.out.println(Arrays.toString(chars1));

        //String Comparison
        String venkatesh1=new String("VENKATESH");
        String venkatesh2=new String(venkatesh1);
        System.out.println(Integer.toHexString(venkatesh1.hashCode()));
        System.out.println(Integer.toHexString(venkatesh2.hashCode()));
        StringBuffer v1=new StringBuffer("Venkatesh");
        StringBuffer v2=new StringBuffer("Venkatesh");
        System.out.println(Integer.toHexString(v1.hashCode()));
        System.out.println(Integer.toHexString(v2.hashCode()));

    }
}
class Stringg{
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        System.out.println(s1 + " equals " + s2 + " -> " +
                s1.equals(s2));
        System.out.println(s1 + " == " + s2 + " -> " + (s1 == s2));
        System.out.println(Integer.toHexString(s1.hashCode()));
        System.out.println(Integer.toHexString(s2.hashCode()));
        System.out.println(s1.getClass());
        System.out.println(s2.getClass());
    }
}
class Parent{
    int parentVariable;
    void parentMethod(){
        System.out.println("parent method invoked");
    }
}
class Child extends Parent{
    int childVariable;
    void childMethod(){
        System.out.println("child method invoked");
    }
}
class Demo{
    public static void main(String[] args) {
        Child childref=new Child();
        childref.childMethod();
    }
}