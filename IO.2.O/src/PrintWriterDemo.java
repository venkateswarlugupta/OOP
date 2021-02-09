import java.io.*;

public class PrintWriterDemo {
    public static void main(String[] args) {
        try {
            File file = new File("file3.txt");
            PrintWriter pw = new PrintWriter(file);
            pw.println("This is Venkateswarlu");
            pw.println("Done!");
            pw.flush();
            pw.close();
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            System.out.println(br.readLine());
            System.out.println(br.readLine());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}