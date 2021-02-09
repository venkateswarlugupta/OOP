package serializable;

import java.io.*;

class Maggie implements Serializable {
    int onions, chillies, Coriander, total;
    public Maggie(int a, int b, int c) {
        this.onions = a;
        this.chillies = b;
        this.Coriander = c;
    }
    void prepare() {
        this.total = this.onions + this.chillies + this.Coriander;
    }
}

public class SerializationThreads {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(new Execution(new Maggie(i, i + 1, i + 2)));
            t.start();
            t.join();
        }
    }
}

class Execution implements Runnable {
    Maggie obj;
    public Execution(Maggie obj) {
        this.obj = obj;
    }
    public void run() {
        obj.prepare();
        try {
            FileOutputStream fis = new FileOutputStream("D:\\VCE\\OOP\\All\\src\\serializable\\sthread.txt");
            ObjectOutputStream ob = new ObjectOutputStream(fis);
            ob.writeObject(obj);
            System.out.println("Seriailization successful :-)))");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}