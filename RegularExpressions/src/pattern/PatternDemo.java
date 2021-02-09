package pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDemo {
    public static void main(String[] args) {

        /*Pattern pat;
        Matcher mat;
        boolean found;
        pat = Pattern.compile("Java");
        mat = pat.matcher("Java");
        found = mat.matches(); // check for a match
        System.out.println("Testing Java against Java.");
        if (found) System.out.println("Matches");
        else System.out.println("No Match");
        System.out.println();
        System.out.println("Testing Java against Java SE 6.");
        mat = pat.matcher("Java SE 6"); // create a new matcher
        found = mat.matches(); // check for a match
        if (found) System.out.println("Matches");
        else System.out.println("No Match");*/

       /* Pattern pattern=Pattern.compile("[\\d]*");
        System.out.println(pattern.matcher("123").matches());
        System.out.println(pattern.matcher("123").start());
        System.out.println(Pattern.matches("ab", "ab"));

        Pattern pattern1=Pattern.compile("[\\d]+");
        System.out.println(pattern1.matcher("63oo63").start());*/

        Pattern p=Pattern.compile("a{3,6}");
        System.out.println(p.matcher("aaaaaaaaa").regionStart());
        System.out.println(p.matcher("aaaabaaabaa").regionEnd());
    }
}
