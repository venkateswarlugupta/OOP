
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class ByteArrayOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream f = new ByteArrayOutputStream();
        String s = "The itsy bitsy spider climbed up the waterspout.\n" +
                "Down came the rain\n" +
                "and washed the spider out.\n" +
                "Out came the sun\n" +
                "and dried up all the rain\n" +
                "and the itsy bitsy spider climbed up the spout again.";
        byte[] buf = s.getBytes();
        f.write(buf);
        System.out.println("Buffer as a string");
        System.out.println(f.toString());
        System.out.println("Into array");
        byte[] b = f.toByteArray();
        for (byte value : b) {
            System.out.print((char) value);
        }
        System.out.println("\nTo an OutputStream()");
        OutputStream f2 = new FileOutputStream("test.txt");
        f.writeTo(f2);
        f2.close();
        System.out.println("Doing a reset");
        f.reset();
        System.out.println(f.toString());
        System.out.println("Spod\nVoicify:)))");
    }
}