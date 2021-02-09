import pattern.PatternDemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
//        String s="i am a string";
//        System.out.println(s);
//
//        String ss=s.replaceAll("i","you");
//        System.out.println(ss);
//
//        String sss="abcdeeefgoirgtrefdslk";
//        System.out.println(sss.replaceAll(".","y"));
//
//        String ssss="abcabcabc";
//        System.out.println(ssss.replaceAll("^abc","ABC"));
//
//        String sssss="adbcabdabc";
//        System.out.println(sssss.replaceAll("[ab][d]","XX"));
//        System.out.println(sssss.replace("[ab][d]","XX"));

        /*String s = "Venkatev119sh";
        System .out.println(s.replaceAll("[^Vv]",""));
        System.out.println(s.replaceAll("(?i)[v]","G"));
        System.out.println(s.replaceAll("\\d","G"));
        System.out.println(s.replaceAll("\\D","G"));

        String ss="I dont like you\t";
        System.out.println(ss.replaceAll("\\S","")+"END");*/
        //String ss="abcDeeeF12Ghhiiiijkl99z";
        //System.out.println(ss.replaceAll("[abcdef345678]","x"));
        //System.out.println(ss.replaceAll("[a-f3-6]","x"));

//        String ss="abcDeeeasdgffadhtr2352p";
//        System.out.println(ss.replaceAll("^abcDe{3}","OKIE"));
//        System.out.println(ss.replaceAll("^abcDe+","OKIE"));
//        System.out.println(ss.replaceAll("^abcDe*","OKIE"));
//
//        System.out.println(ss.replaceAll("^abcDe{2,5}","OKIE"));
//
//        String sss="abcDeeeF12Ghhiiiijkl99z";
//        System.out.println(sss.replaceAll("h+i*j","Y"));

        StringBuilder htmlText=new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph</p>");
        htmlText.append("<p>This is  anotehr paragraph</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Herer is the summary.</p>");

        String h2Pattern="<h2>";
        Pattern pattern=Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE|Pattern.UNICODE_CASE);
        Matcher matcher=pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        matcher.reset();
        int count=0;
        while(matcher.find()){
            count++;
            System.out.println("Occurrence "+ count + " : " +  matcher.start() + " to " + matcher.end());
        }

        //String h2GroupPattern="(<h2>.*</h2>)";
        String h2GroupPattern="(<h2>.*?</h2>)";
        Pattern groupPattern=Pattern.compile(h2GroupPattern);
        Matcher groupMatcher=groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while (groupMatcher.find()){
            System.out.println("Occurrence : "+groupMatcher.group(1));
        }

        String h2TextGroups="(<h2>)(.+?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher= h2TextPattern.matcher(htmlText);

        while(h2TextMatcher.find()){
            System.out.println("Occurrence : "+h2TextMatcher.group(3));
        }













    }
}
