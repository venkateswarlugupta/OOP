import java.util.ArrayList;

interface SortingUsingBubbleSort {
    public ArrayList<Integer> bubbleSort(ArrayList<Integer> arrayList);
}

public class BubbleSort{
    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(4);
        arrayList.add(8);
        arrayList.add(6);
        arrayList.add(2);
        System.out.print("Before sorting : ");
        arrayList.forEach((n)-> System.out.print(n+" "));
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
        doSorting(sort,arrayList);
        System.out.print("\nAfter sorting : ");
        arrayList.forEach((n)-> System.out.print(n+" "));
    }
    public static ArrayList<Integer> doSorting(SortingUsingBubbleSort sort,ArrayList<Integer> arrayList){
        return sort.bubbleSort(arrayList);
    }
}