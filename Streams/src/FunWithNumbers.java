import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FunWithNumbers {
    public static void main(String[] args) {

        /*int min = numbers[0];
        for(int i=1;i<numbers.length;i++){
            if(min>numbers[i])
                min=numbers[i];
        }
        System.out.println("Minimum is : "+min);*/

        /*System.out.println(IntStream.of(numbers).max().getAsInt());
        System.out.println(IntStream.of(numbers).min().getAsInt());
        System.out.println(IntStream.of(numbers).average().getAsDouble());
        System.out.println(IntStream.of(numbers).sum());
        System.out.println(IntStream.of(numbers).count());
        IntPredicate gt100= number->number>100;
        IntPredicate lt256= number->number<256;
        System.out.println(IntStream.of(numbers).allMatch(gt100));
        System.out.println(IntStream.of(numbers).allMatch(lt256));*/

        /*System.out.println(Arrays.toString(IntStream.of(numbers).distinct().toArray()));

        IntStream.of(numbers)
                .distinct()
                .sorted()
                .limit(3)
                .forEach(x-> System.out.print(x+" "));

        System.out.print("\n"+Arrays.toString(IntStream.range(1, 100).toArray()));*/

        //System.out.println(Arrays.toString(IntStream.of(numbers).limit(3).toArray()));

        //System.out.println(Arrays.toString(IntStream.of(numbers).map(x -> x * 2).toArray()));
        int[] numbers = {4, 1, 13, 119, 11, 2, 9, 2};
        IntStream afterDoingDistinct=IntStream.of(numbers).distinct();
        //IntStream.of(numbers).distinct().map(x -> x * 2).filter(c->c%2==0).sorted()
        //System.out.println(Arrays.toString(IntStream.of(numbers).distinct().map(x -> x * 2).toArray()));
        IntStream ref1=afterDoingDistinct.map(x -> x * 2);
        IntStream ref2=ref1.filter(c->c%2==0);
        System.out.println(ref1);
        System.out.println(ref2);
        System.out.println(ref2.sorted());
    }
}


class StreamFilterDemo {
    String name;
    int fee;
    public StreamFilterDemo(String n, int m)
    {
        this.name=n;
        this.fee = m;
    }
    public static void main(String[] args)
    {
        StreamFilterDemo vce = new StreamFilterDemo("vce", 90000);
        StreamFilterDemo cbit = new StreamFilterDemo("cbit", 120000);
        StreamFilterDemo mgit = new StreamFilterDemo("mgit", 80000);
        StreamFilterDemo ou = new StreamFilterDemo("ou", 85000);
        List<StreamFilterDemo> colleges = Arrays.asList(vce, cbit, mgit, ou);
        List<StreamFilterDemo> collegesWithLessThan100000Fee = colleges.stream().filter(c -> c.fee < 100000).collect(Collectors.toList());
        System.out.println("Colleges with fee lessthan 100000");
        for(StreamFilterDemo clg : collegesWithLessThan100000Fee)
        {
            System.out.println(clg.name + " : " + clg.fee);
        }
    }
}
