package character_stream;

import java.io.File;
import java.io.FileWriter;

public class FileWriterDemo {
    public static void main(String[] args) {
        String s="The itsy bitsy spider climbed up the waterspout.\n" +
                "Down came the rain\n" +
                "and washed the spider out.\n" +
                "Out came the sun\n" +
                "and dried up all the rain\n" +
                "and the itsy bitsy spider climbed up the spout again.";
        try {
            FileWriter fw1 = new FileWriter("D:\\VCE\\OOP\\IO.3.O\\" +
                    "src\\character_stream\\output1.txt",true);
            File f=new File("D:\\VCE\\OOP\\IO.3.O\\src\\character_stream\\output2.txt");
            FileWriter fw2 = new FileWriter(f);
            char[] buffer =new char[s.length()];
            s.getChars(0, buffer.length, buffer, 0);
            for (char c : buffer) {
                fw1.write(c);
            }
            fw1.write('\n');
            fw1.flush();
            fw1.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
