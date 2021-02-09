//import java.io.*;

import java.io.File;
import java.io.FilenameFilter;

class OnlyExt implements FilenameFilter {
    String ext;
    public OnlyExt(String ext) {
        this.ext = "." + ext;
    }
    public boolean accept(File dir, String name) {
        return name.endsWith(ext);
    }
}public class FilenameFilterDemo {
    public static void main(String[] args) {
        String dirname = "F:\\Java\\HelloWorld";
        File f1 = new File(dirname);
        FilenameFilter only = new OnlyExt("java");
        System.out.println(f1.getAbsolutePath());
        String[] s = f1.list(only);
        assert s != null;
        for (String value : s) {
            System.out.println(value);
        }
    }
}
