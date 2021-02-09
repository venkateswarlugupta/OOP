package FileReaderDemo;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderDemo {
    public static void main(String... args){
        Scanner scanner=null;
        try{
            scanner=new Scanner(new FileReader("src\\FileWriterDemo\\letswrite.txt"));
            while (scanner.hasNextLine()){
                String line=scanner.nextLine();
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(scanner!=null){
                scanner.close();
            }
        }
    }
}