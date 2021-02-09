package queue;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> myQ=new LinkedList<>();
        try{
            myQ.add("ABC");
        }catch(IllegalStateException e){
            e.printStackTrace();
        }
        myQ.offer("DEF");
        boolean flag=myQ.offer("GHI");
        System.out.println("Is third element added successfully : "+flag);
        System.out.println("Peek the head : "+myQ.peek());
        String head= myQ.poll();//myQ.remove();
        System.out.println("head is removed(poll) : "+head);
        System.out.println("new head is : "+myQ.element());
        try{
            head=myQ.remove();
            System.out.println("removed out(remove) : "+head);
            System.out.println("new new head is : "+myQ.element());
        }catch(NoSuchElementException e){
            e.printStackTrace();
        }

        System.out.println("Does Q contains? \"ABC\" "+myQ.contains("ABC"));
        System.out.println("Does Q contains? \"DEF\" "+myQ.contains("DEF"));
        System.out.println("Does Q contains? \"GHI\" "+myQ.contains("GHI"));
    }
}
