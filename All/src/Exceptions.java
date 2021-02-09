class SpodException extends Exception {
    SpodException(){
        //
    }

    @Override
    public String toString() {
        return "moreover that much you don\'t require";
    }
}
class OutcomeBaseduuEducation extends Throwable{
    OutcomeBaseduuEducation(){
        //
    }
}
public class Exceptions {
    public static void main(String[] args) {
        try{
            System.out.println("Dividing by zero ");
            System.out.println(10/0);
        }catch(Exception e){
            System.out.println(e.toString());
        }
        try{
            int arr[]=new int[2];
            arr[0]=0;arr[1]=1;
            System.out.println("accessing out of bounds elements");
            System.out.println(arr[2]);
        }catch (Exception e){
            System.out.println(e.toString());
        }
        try{
            throw new SpodException();
        }catch(Exception e){
            System.out.println(e.toString());
        }
        try{
            throw new OutcomeBaseduuEducation();
        }catch(OutcomeBaseduuEducation e){
            System.out.println("I decided :)");
        }
    }
}