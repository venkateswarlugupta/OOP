package FileWriterDemo;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        // catch is to do something when exception occurs
        // if there is nothing to do, use throws
// https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
//        try(FileWriter letsWrite=new FileWriter("src\\FileWriterDemo\\letswrite.txt")){
//            String[] poem = {
//                    "Humpty Dumpty sat on a wall\n",
//                    "Humpty Dumpty had a great fall;\n",
//                    "All the king's horses and all the king's men\n",
//                    "Couldn't put Humpty together again.\n"
//            };
//            for (String line : poem) {
//                letsWrite.write(line);
//            }
//        }
        FileWriter letsWrite = null;
        try {
            letsWrite = new FileWriter("src\\FileWriterDemo\\letswrite.txt");
            String[] poem = {
                    "Humpty Dumpty sat on a wall\n",
                    "Humpty Dumpty had a great fall;\n",
                    "All the king's horses and all the king's men\n",
                    "Couldn't put Humpty together again.\n"
            };
            for (String line : poem) {
                letsWrite.write(line);
            }
        } finally {
            System.out.println("In finally block");
            if (letsWrite != null) {
                System.out.println("Attempting to close");
                letsWrite.close();
            }
        }
    }
}
/*
public class FileWriterDemo {
    public static void main(String[] args) {
        FileWriter letsWrite=null;
        try {
            letsWrite = new FileWriter("src\\FileWriterDemo\\letswrite.txt");
            String[] poem={
                    "Humpty Dumpty sat on a wall\n",
                    "Humpty Dumpty had a great fall;\n",
                    "All the king's horses and all the king's men\n",
                    "Couldn't put Humpty together again.\n"
            };
            for(String line:poem){
                letsWrite.write(line);
            }
        }catch(IOException e){
            System.out.println("In catch block");
            e.printStackTrace();
        }finally {
            System.out.println("In finally block");
            try {
                if(letsWrite!=null) {
                    System.out.println("Attempting to close");
                    letsWrite.close();
                }
            }catch (IOException e){
                System.out.println("In catch block");
                e.printStackTrace();
            }
        }
    }
}
*/