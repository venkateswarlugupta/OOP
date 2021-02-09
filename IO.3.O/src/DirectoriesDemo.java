import java.io.File;

public class DirectoriesDemo {
    public static void main(String[] args) {
        String dirname = "F:\\Java\\HelloWorld";
        File f1 = new File(dirname);
        if (f1.isDirectory()) {
            System.out.println("Directory of " + dirname);
            //String[] s = f1.list();
            File[] files=f1.listFiles();
            assert files != null;
            for(File value:files){
                if (value.isDirectory()) {
                    System.out.println(value + " is a directory");
                } else {
                    System.out.println(value + " is a file");
                }
            }
//            for (String value : s) {
//                File f = new File(dirname + "/" + value);
//                if (f.isDirectory()) {
//                    System.out.println(value + " is a directory");
//                } else {
//                    System.out.println(value + " is a file");
//                }
//            }
        } else {
            System.out.println(dirname + " is not a directory");
        }
    }
}