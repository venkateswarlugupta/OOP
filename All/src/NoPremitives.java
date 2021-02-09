import java.applet.Applet;
import java.awt.*;
import java.io.IOException;

class nptel{
    public static void main(String[] args) {
        char x='1', y='2';
        System.out.println(x-y+x);
        System.out.println(x-y);
        System.out.println(x+x-y);
        System.out.println(x+y);
        System.out.print(true+""+true);
        int i=4;
        System.out.println(--i*8);

        /*int arr[]={0, 1, 2, 3, 4, 5, 6, 7};
        for(int b=5;b>2;b-=2){
            System.out.println(arr[--b]);
        }*/
    }
}
class HelloWorld extends Applet {
    public void paint(Graphics g) {
        g.drawString("Hello World!",150,150);
    }
}
public class NoPremitives {
    public static void main(String... args) throws IOException {

        for(int i=0,j,k;i<3;i++)
            for(j=0;j<3;j++)
                for(k=0;k<3;k++)
                    System.out.println("FuckOff");

        /*int[][] a={{1,2},{4,5,6}};
        int[][] arr= new int[][]{{1, 2}, {3, 4}};
        for(int j,i=0;i<a.length;i++){
            for(j=0;j<a[i].length;j++){
                System.out.println(a[i][j]);
            }
        }*/
        //int arr[2][3]={{1, 3, }, {4, 5, 6}};
        /*Float principalAmount = new Float(0);
        Float rateOfInterest = new Float(0);
        Float totalInterest = new Float(0);
        Integer numberOfYears = new Integer(0);

        DataInputStream in =new DataInputStream(System.in);
        String tempString;
        System.out.print("Enter principal amount : ");
        System.out.flush();
        tempString = in.readLine();
        principalAmount = Float.valueOf(tempString);
        System.out.print("Enter rate of Interest : ");
        System.out.flush();
        tempString = in.readLine();
        rateOfInterest = Float.valueOf(tempString);
        System.out.println("Enter number of years : ");
        System.out.flush();
        tempString = in.readLine();
        numberOfYears = Integer.parseInt(tempString);

        totalInterest = principalAmount * rateOfInterest * numberOfYears;
        System.out.println("Total interest : " + totalInterest);*/

    }
}
