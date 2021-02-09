import java.util.ArrayList;

interface SearchUsingBinarySearch{
    public int binarySearch(ArrayList<Integer> arrayList, int key, int l, int r);
}

public class BinarySearch {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<>(),sortedArrayList=new ArrayList<>();
        arrayList.add(4);
        arrayList.add(8);
        arrayList.add(6);
        arrayList.add(2);
        SearchUsingBinarySearch search = (arrayList1, key, l, r) -> {
            while(r>=l){
                int mid=l+(r-l)/2;
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
        System.out.println(doSearch(search, arrayList, 10, 0, arrayList.size()-1));
    }
    public static int doSearch(SearchUsingBinarySearch search, ArrayList<Integer> arrayList, int key, int l, int r){
        return search.binarySearch(arrayList, key, l,r);
    }
}