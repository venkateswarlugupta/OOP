import java.io.*;

public class MkDir {
    public static void main(String[] args) {
        try {
            File myDir = new File("Directory");
            myDir.mkdir();
            File myFile=new File(myDir,"file.txt");
            myFile.createNewFile();
            PrintWriter pw=new PrintWriter(myFile);
            pw.println("1st line");
            pw.println("2nd line");
            pw.flush();
            pw.close();
            FileReader fr=new FileReader(myFile);
            BufferedReader br=new BufferedReader(fr);
            System.out.println(br.readLine());
            System.out.println(br.readLine());
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
