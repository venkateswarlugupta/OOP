public class MethodsInStrings {
//  https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#contentEquals(java.lang.CharSequence)
    public static void main(String[] args) {
        /*
            public boolean regionMatches(int toffset,
                        String other,
                        int ooffset,
                        int len)

            toffset - the starting offset of the subregion in this string.
            other - the string argument.
            ooffset - the starting offset of the subregion in the string argument.
            len - the number of characters to compare.
        */
        String name="Venkateswarlu";
        String substr="kat";
        System.out.println(name.regionMatches(3,substr,0,3));

        /*
            public boolean regionMatches(boolean ignoreCase,
                    int toffset,
                    String other,
                    int ooffset,
                    int len)
            ignoreCase - if true, ignore case when comparing characters.

        */
        String name1="VenKAteswaRlu";
        String substr1="Kat";
        System.out.println(name1.regionMatches(false,3,substr1,0,3));

        System.out.println(name1.startsWith("KAt",3));
        System.out.println(name1.indexOf('e',1));
        System.out.println(name1.lastIndexOf('e',3));
        System.out.println(name1.indexOf("KAt"));
        CharSequence subseq=name1.subSequence(1,4);
        for(int i=0;i<subseq.length();i++){
            System.out.print(subseq.charAt(i)+" ");
        }
    }
}
