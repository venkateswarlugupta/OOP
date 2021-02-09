import java.io.File;
import java.io.IOException;

public class DeleteRemove {
    public static void main(String[] args) {
        try{
            File delDir=new File("deldir");
            delDir.mkdir();
            File delFile1=new File(delDir,"delFile1.txt");
            delFile1.createNewFile();
            System.out.println("Is delDir a file?\n"+delDir.isFile());
            System.out.println("Is delDir a Directory?\n"+delDir.isDirectory());
            System.out.println("Is delFile1 a file?\n"+delFile1.isFile());
            System.out.println("Is delFile1 a Directory?\n"+delFile1.isDirectory());
            File delFile2=new File(delDir, "delFile2.txt");
            delFile2.createNewFile();
            delFile1.delete(); // delete a file
            System.out.println("deldir is "+delDir.delete());
            File newName=new File(delDir,"newName.txt");
            delFile2.renameTo(newName);
            File newDir=new File("newDir");
            delDir.renameTo(newDir);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
