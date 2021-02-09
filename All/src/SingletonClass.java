// When a class has no attribute, so it has no state and we are passing value as method parameters,
// in that case there is no need to create multiple objects .
// By creating single object we can call that methods multiple times.

// When the case is read-only state then at that case also there is no need to create multiple objects,
// we can declare singleton.

class Circle{
    public static Circle circle=null;// creating reference
    public static Object object=null;// creating reference
    private Circle(){
        //
    }

    public double area(double radius){
        return radius*radius*3.14;
    }

    public static Circle getCircle(){
        if(circle==null){
            circle=new Circle();// creating instance
            object=new Circle();// creating instance
        }
        //return circle;// returning instance
        return (Circle)object;// returning instance
    }
}
public class SingletonClass {
    private String name;
    public static SingletonClass singletonClass=null;
    private SingletonClass(){
        name="";
    }

    public static SingletonClass getSingletonClass(){
        if(singletonClass==null){
            singletonClass=new SingletonClass();
        }
        return singletonClass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String getName(){
        return name;
    }

    public boolean isPrime(int n) { // for checking
        if ((n != 2 && n % 2 == 0) || n == 1) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public boolean isEven(int n) {
        return (n & 1) == 0;
    }
}
class SingletonClassMain{
    public static void main(String[] args) {
        SingletonClass singletonClass1=SingletonClass.getSingletonClass();
        SingletonClass singletonClass2=SingletonClass.getSingletonClass();
        SingletonClass singletonClass3=SingletonClass.getSingletonClass();
        Circle circle=Circle.getCircle();
        System.out.println("Address of 1st Instance : "+singletonClass1.toString());
        System.out.println("Address of 2st Instance : "+singletonClass2.toString());
        System.out.println("Address of 3st Instance : "+singletonClass3.toString());
        System.out.println("Area : "+circle.area(2));
        System.out.println("From 1st instance : "+singletonClass1.getName());
        singletonClass1.setName("VENKATESWARLU GUPTA");
        System.out.println("From 2nd instance : "+singletonClass2.getName());
        singletonClass1.setName("GUPTA");
        System.out.println("From 3rd instance : "+singletonClass3.getName());

        System.out.println(singletonClass1.isEven(2));
        System.out.println(singletonClass2.isEven(3));
        System.out.println(singletonClass3.isPrime(4));
    }
}