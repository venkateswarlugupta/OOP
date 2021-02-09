import java.util.stream.IntStream;
import java.util.stream.Stream;

public abstract class MyStream<T> implements Stream<T> {


}
class IntStreamDemo{
    public static void main(String[] args) {
        IntStream.of(2, 19, 4, 3, 21, 5, 2).distinct().forEach(System.out::println);
    }
}
