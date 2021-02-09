import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

class Timerr{
    private static Timer t1,t2;
    private static TimerTask tt1,tt2;
    public static void main(String[] args) {
        t1=new Timer();
        t2=new Timer();
        tt1=new TimerTask() {
            public void run() {
                System.out.println(new GregorianCalendar().getTime());
                t1.cancel();
            }
        };
        tt2=new TimerTask() {
            public void run() {
                System.out.println(new GregorianCalendar().getTime());
                t2.cancel();
            }
        };
        t1.schedule(tt1,1000);
        t2.schedule(tt2,2000);
    }
}*/
public class SimpleCalculator {
    public static void main(String[] args) {
        MyFrame frame=new MyFrame();
    }
}

class MyFrame extends JFrame implements ActionListener {
    private Container c;
    private JLabel label1, label2, result;
    private JTextField t1, t2;
    private JButton addition, multiplication, substraction, division;
    MyFrame(){
        setTitle("Simple Calculator");
        setSize(300,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        c=getContentPane();
        c.setLayout(null);

        label1=new JLabel("First Number : ");
        label1.setBounds(10, 20, 100, 20);
        c.add(label1);

        t1=new JTextField();
        t1.setBounds(120, 20, 100, 20);
        c.add(t1);

        label2=new JLabel("Second Number : ");
        label2.setBounds(10, 50, 100, 20);
        c.add(label2);

        t2=new JTextField();
        t2.setBounds(120, 50, 100, 20);
        c.add(t2);

        addition =new JButton("+");
        addition.setBounds(10, 80, 50, 30);
        c.add(addition);

        substraction =new JButton("-");
        substraction.setBounds(70, 80, 50, 30);
        c.add(substraction);

        multiplication =new JButton("*");
        multiplication.setBounds(130, 80, 50, 30);
        c.add(multiplication);

        division =new JButton("/");
        division.setBounds(190, 80, 50, 30);
        c.add(division);

        result=new JLabel("Result : ");
        result.setBounds(10, 120, 150, 20);
        c.add(result);

        addition.addActionListener(this);
        substraction.addActionListener(this);
        multiplication.addActionListener(this);
        division.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int a = Integer.parseInt(t1.getText());
        int b = Integer.parseInt(t2.getText());
        try {
            if (e.getSource() == addition) {
                result.setText("Result : " + (a + b));
            }
            if (e.getSource() == substraction) {
                result.setText("Result : " + (a - b));
            }
            if (e.getSource() == multiplication) {
                result.setText("Result : " + (a * b));
            }
            if (e.getSource() == division) {
                result.setText("Result : " + (a / b));
            }
        }catch(NumberFormatException numberFormatException){
            System.out.println("Please enter integers");
        }catch(ArithmeticException arithmeticException){
            System.out.println("Can't divide by zero");
        }
    }
}