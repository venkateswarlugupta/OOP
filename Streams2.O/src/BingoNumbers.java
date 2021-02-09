import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class BingoNumbers {
    public static void main(String... args){
        List<String> someBingoNumbers= Arrays.asList(
                "B2", "B3", "B12", "B9",
                "I16", "I27",
                "N33", "N44", "B40",
                "G59", "G49",
                "O61"
        );
        //someBingoNumbers.forEach(bingoNumber -> System.out.println(bingoNumber));
        //someBingoNumbers.forEach(System.out::println);

       /* List<String> gNumbers=new ArrayList<>();
        someBingoNumbers.forEach(number->{
            if(number.toUpperCase().startsWith("G")){
                gNumbers.add(number);
                System.out.println(number);
            }
        });
        gNumbers.sort((String s1, String s2)->s1.compareTo(s2));
        gNumbers.forEach((String s)-> System.out.println(s));*/

        someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s->s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);
    }
}

class Streammm{
    public static void main(String[] args) {
        int[] numbers={3,1,4,5,2};
        //.of(numbers).filter().sorted().forEach(System.out::println);

    }

    public static IntStream squaring(int[] numbers){
        IntStream s=IntStream.of(numbers);
        return s;
    }
}

class BinarySearchUsingStreamFilterMethod{
    public static void main(String[] args) {
        IntStream.of(2,6,8,3,7,4,3).distinct().sort().filter()
    }
    
}