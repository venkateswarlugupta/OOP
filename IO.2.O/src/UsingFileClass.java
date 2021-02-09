import java.io.*;

public class UsingFileClass {
    public static void main(String... args){
        File file=new File("file1.txt");
        // There is no file yet!
    }
}
class Write{
    public static void main(String[] args) {
        try{
            boolean newFile=false;
            File file=new File("file1.txt");
            System.out.println(file.setLastModified(2));
            System.out.println(file.exists());
            newFile=file.createNewFile();
            System.out.println(newFile);
            System.out.println(file.exists());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
