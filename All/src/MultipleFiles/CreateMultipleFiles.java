package MultipleFiles;

import java.io.FileWriter;

public class CreateMultipleFiles {
    public static void main(String[] args) {
        CreateFile file1=new CreateFile(11,"Eleventh file\n", ThreadColor.ANSI_BLUE);
        CreateFile file2=new CreateFile(12,"Twelfth file\n", ThreadColor.ANSI_CYAN);
        CreateFile file3=new CreateFile(13,"Thirteen file\n", ThreadColor.ANSI_GREEN);
        CreateFile file4=new CreateFile(14,"Fourteenth file\n", ThreadColor.ANSI_PURPLE);
        CreateFile file5=new CreateFile(15,"Fifteenth file\n", ThreadColor.ANSI_RED);
        (new Thread(file1)).start();
        (new Thread(file2)).start();
        (new Thread(file3)).start();
        (new Thread(file4)).start();
        (new Thread(file5)).start();
    }
}
class ThreadColor {
    public static final String ANSI_RESET="\u001B[0m";
    public static final String ANSI_BLACK="\u001B[30m";
    public static final String ANSI_RED="\u001B[31m";
    public static final String ANSI_GREEN="\u001B[32m";
    public static final String ANSI_LIGHT_YELLOW = "\u001B[93m";
    public static final String ANSI_YELLOW = "\u001b[33m";
    public static final String ANSI_BLUE="\u001B[34m";
    public static final String ANSI_PURPLE="\u001B[35m";
    public static final String ANSI_CYAN="\u001B[36m";
    public static final String ANSI_WHITE="\u001B[37m";
}
class CreateFile implements Runnable{
    int fileNumber;
    String fileContent;
    String threadColor;
    CreateFile(int fileNumber, String fileContent, String threadColor){
        this.fileContent=fileContent;
        this.fileNumber=fileNumber;
        this.threadColor=threadColor;
    }
    public void createFile() throws Exception{
        FileWriter fileWriter=new FileWriter("D:\\VCE\\OOP\\All\\src\\MultipleFiles\\file"+fileNumber+".txt", false);
        char[] buffer=new char[fileContent.length()];
        fileContent.getChars(0,buffer.length,buffer,0);
        for(char c:buffer){
            fileWriter.write(c);
        }
        fileWriter.flush();
        fileWriter.close();
    }
    public void run() {
        try{
            if(fileNumber==13) throw new Exception();
            createFile();
            System.out.println(threadColor+"Successfully created "+fileNumber+"th file :)");
        }catch(Exception e){
            System.out.println(threadColor+"Unable to create "+fileNumber+"th file :(");
        }
    }
}