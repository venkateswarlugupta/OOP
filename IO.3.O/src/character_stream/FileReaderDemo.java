package character_stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String... args) throws IOException {
        FileReader fr=new FileReader("D:\\VCE\\OOP\\IO.3.O\\src\\character_stream\\input1.txt");
        //File f=new File("D:\\VCE\\OOP\\IO.3.O\\src\\input1.txt");
        BufferedReader br=new BufferedReader(fr);
        String s;
        while((s=br.readLine())!=null){
            System.out.println(s);
        }
        br.close();
        fr.close();
    }
}
