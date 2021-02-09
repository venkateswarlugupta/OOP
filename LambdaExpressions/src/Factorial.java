import java.io.BufferedReader;
import java.io.InputStreamReader;

interface Fact{
    int calculateFactorial(int n);
}
public class Factorial {
    private static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        System.out.print("Enter a number to calculate factorial : ");
        int number=Integer.parseInt(br.readLine());
        Fact f=(n)->{
            int product = 1;
            while (n>0){
                product*=n;
                n--;
            }
            return product;
        };
        System.out.println(factorialIs(f,number));
    }
    public static int factorialIs(Fact f, int n){
        return f.calculateFactorial(n);
    }
}