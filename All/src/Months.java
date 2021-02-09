import java.util.*;

public enum Months {
    JAN, FEB, MAR, APR
}

class DemoEnum {
    public static void main(String[] args) {
        for (Months month : Months.values()) {
            System.out.println(month);
        }
    }
}

class Singer {
    String name;

    Singer(String name) {
        this.name = name;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Singer singer = (Singer) o;
        return Objects.equals(name, singer.name);
    }

    public int hashCode() {
        return Objects.hash(name);
    }
}

class Player {
    String name;

    Player(String name) {
        this.name = name;
    }
}

class Mainnn {
    public static void main(String[] args) {
        Player player1 = new Player("Virat");
        Player player2 = new Player("Virat");
        System.out.println("is player1 and player2 equal : " + player1.equals(player2));
        Singer shreya1 = new Singer("Shreya Ghoshal");
        Singer shreya2 = new Singer("Shreya Ghoshal");
        System.out.println("is shreya1 and shreya2 equal : " + shreya1.equals(shreya2));
        System.out.println(shreya1.getClass());
        System.out.println(shreya2.getClass());
    }
}

class DemoforEachMethod {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(5);
        arrayList.add(2);
        arrayList.forEach(n -> System.out.println("Hello"));
    }
}
interface IFactorial{
    int calculateFactorial(int n);
}
class FactorialUsingLambdaExpressions{
    public static void main(String[] args) {
        IFactorial iFactorial = (n) -> {
            int product = 1;
            while(n>0){
                product*=n--;
            }
            return product;
        };
        System.out.println(findFactorial(iFactorial,5));
    }
    public static int findFactorial(IFactorial iFactorial, int n){
        return iFactorial.calculateFactorial(n);
    }
}

