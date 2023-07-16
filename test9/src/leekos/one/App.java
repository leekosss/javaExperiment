package leekos.one;

import java.io.*;

public class App {
    public static void main(String[] args) throws IOException {

//            CopyByLine c = new CopyByLine("a.txt","b.txt");
//            c.copyFile();
//        CopyByAll copyByAll = new CopyByAll("aa.txt","bb.txt");
//        copyByAll.copyFile();
        CopyByChar copyByChar = new CopyByChar("x.txt","xx.txt");
        copyByChar.copy();

    }
}

class CopyByChar {

    private String oldName,newName;
    private BufferedReader br;
    private BufferedWriter bw;

    public CopyByChar(String oldName,String newName) throws IOException {
        this.oldName = oldName;
        this.newName = newName;
        br = new BufferedReader(new FileReader(oldName));
        bw = new BufferedWriter(new FileWriter(newName));
        System.out.println("复制成功！");
    }

    public void copy() throws IOException {
        int x;
        while((x = br.read())!=-1) {
            bw.write(x);
        }
        bw.close();
        br.close();
    }
}

class CopyByLine {
    private String oldName,newName;
    private BufferedReader br;
    private BufferedWriter bw;

    public CopyByLine(String oldName,String newName) {
        this.oldName = oldName;
        this.newName = newName;
        try {
            bw = new BufferedWriter(new FileWriter("D:/" + newName));
        } catch (IOException e) {
            System.out.println("文件已存在！");
        }
        try {
            br = new BufferedReader(new FileReader("D:/" + oldName));

        } catch (IOException e) {
            System.out.println("没有找到该文件！");
        }
    }

    public void copyFile() throws IOException {
        String line;
        while((line=br.readLine())!=null) {
            bw.write(line);
            bw.newLine();
        }
        System.out.println("复制成功！");
        br.close();
        bw.close();
    }

}

class CopyByAll {
    private File file;
    private String oldName,newName;
    private BufferedReader br;
    private BufferedWriter bw;

    public CopyByAll(String oldName,String newName) {
        this.oldName = oldName;
        this.newName = newName;
        try {

            bw = new BufferedWriter(new FileWriter("D:/" + newName));
        } catch (IOException e) {
            System.out.println("文件已存在！");
        }
        try {
            file = new File("D:/" + oldName);
            br = new BufferedReader(new FileReader(file));

        } catch (IOException e) {
            System.out.println("没有找到该文件！");
        }
    }

    public void copyFile() throws IOException {
        char[] chr = new char[(int)file.length()];
        br.read(chr);
        bw.write(chr);
        br.close();
        bw.close();
        System.out.println("复制成功！");
    }

}