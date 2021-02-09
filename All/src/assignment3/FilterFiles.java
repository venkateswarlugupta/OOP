package assignment3;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class FilterFiles {
    public static void main(String[] args) throws NumberFormatException, IOException {
        InputStreamReader ins = new InputStreamReader(System.in);
        BufferedReader buff = new BufferedReader(ins);
        System.out.println("1 Files starting with...\n2 Files with extension...\n");
        switch (Integer.parseInt(buff.readLine())) {
            case 1:
                File filePath = new File("F:\\vs code");
                String[] list;
                System.out.println("Enter regex\n");
                String regex = buff.readLine();
                list = filePath.list(new DirFilter(regex));
                assert list != null;
                for (String s : list) System.out.println(s);
                break;
            case 2:
                File file = new File("F:\\vs code");
                String[] l;
                System.out.println("Enter regex\n");
                String reg = buff.readLine();
                l = file.list(new filter(reg));
                assert l != null;
                System.out.println("Total such files : "+l.length);
                //assert l != null;
                for (String s : l) System.out.println(s);
                break;
        }
    }
}
class DirFilter implements FilenameFilter {
    private Pattern pattern;
    public DirFilter(String reg) {
        pattern = Pattern.compile(reg);
    }
    public boolean accept(File dir, String name) {
        return pattern.matcher(new File(name).getName()).matches();
    }
}
class filter implements FilenameFilter {
    private Pattern pattern;
    public filter(String reg) {
        pattern = Pattern.compile(reg);
    }
    public boolean accept(File dir, String name) {
        //System.out.println(name);
        //System.out.println(name.substring(name.lastIndexOf('.')));
        return pattern.matcher(name).matches();
        //return true;
    }
}

class R{
    public static void main(String[] args) {
        Pattern pattern=Pattern.compile(".+.txt$");
        Matcher matcher=pattern.matcher("1602-19-733-119.txt");
        System.out.println(matcher.matches());
    }
}

interface SortingUsingBubbleSort {
    public ArrayList<Integer> bubbleSort(ArrayList<Integer> arrayList);
}
interface SearchUsingBinarySearch{
    public int binarySearch(ArrayList<Integer> arrayList, int key, int l, int r);
}
class FewLambdaExpressions{
    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<>(),sortedArrayList=new ArrayList<>();
        arrayList.add(4);
        arrayList.add(8);
        arrayList.add(6);
        arrayList.add(2);
        SortingUsingBubbleSort sort=(arrayList1)->{
            for(int j,i=0;i<arrayList.size();i++){
                for(j=0;j<arrayList.size();j++){
                    if(arrayList.get(i)<arrayList.get(j)){
                        arrayList.set(i, arrayList.get(i)+arrayList.get(j));
                        arrayList.set(j, arrayList.get(i)-arrayList.get(j));
                        arrayList.set(i, arrayList.get(i)-arrayList.get(j));
                    }
                }
            }
            return arrayList1;
        };
        System.out.println(doSorting(sort,arrayList));
        SearchUsingBinarySearch search = (arrayList1, key, l, r) -> {
            int mid=1+(r-l)/2;
            while(r>=l){
                if (arrayList1.get(mid) == key)
                    return mid;
                if( arrayList1.get(mid)>key){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }
            return -1;
        };
        System.out.println(doSearch(search, arrayList, 6, 0, arrayList.size()-1));
    }
    public static ArrayList<Integer> doSorting(SortingUsingBubbleSort sort, ArrayList<Integer> arrayList){
        return sort.bubbleSort(arrayList);
    }
    public static int doSearch(SearchUsingBinarySearch search, ArrayList<Integer> arrayList, int key, int l, int r){
        return search.binarySearch(arrayList, key, l,r);
    }
}