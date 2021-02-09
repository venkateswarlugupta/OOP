package StringHandling;

public class Practice1 {
    public static void main(String... args){
        String bengaluru="Bengaluru",bangalore="Bangalore",mangalore="MANGALORE";
        System.out.println(bengaluru.regionMatches(2,bangalore,2,3));
        System.out.println(bengaluru.regionMatches( false,2,mangalore,2,3));
        System.out.println(bengaluru.regionMatches( true,2,mangalore,2,3));
    }
}
class StringReplace {
    public static void main(String args[]) {
        String org = "This is a test. This is, too.";
        String search = "is";
        String sub = "was";
        String result = "";
        int i;
        do { // replace all matching substrings
            System.out.println(org);
            i = org.indexOf(search);
            if(i != -1) {
                result = org.substring(0, i);
                result = result + sub;
                result = result + org.substring(i + search.length());
                org = result;
            }
        } while(i != -1);
    }
}