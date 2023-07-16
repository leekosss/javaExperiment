package leekos.three;

import java.io.*;

public class App {
    public static void main(String[] args) throws IOException {
        FibonacciToFile f = new FibonacciToFile("x");
        f.writeToFile();
    }
}

class FibonacciToFile {
    private String fileName;
    private BufferedWriter bw;
    private DataOutputStream dos;
    public FibonacciToFile(String fileName) throws IOException {
        this.fileName = fileName;
        bw = new BufferedWriter(new FileWriter(fileName + ".txt"));
        dos = new DataOutputStream(new FileOutputStream(fileName + ".dat"));
    }

    public void writeToFile() throws IOException {
        int f1 = 1, f2 = 1,count=0;
        while(count < 20) {
            bw.write(f1+" ");
            bw.write(f2+" ");
            dos.writeInt(f1);
            dos.writeInt(f2);
            f1 = f1 + f2;
            f2 = f1 + f2;
            count += 2;
        }

        bw.close();
        dos.close();
        System.out.println("Fibonacci to file success!");

    }

}
