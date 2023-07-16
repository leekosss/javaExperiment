package leekos.two;

import java.io.*;

public class App {
    public static void main(String[] args) throws IOException {
        CopyFile c = new CopyFile("a.dat","aa.dat");
        c.copy();
    }
}

class CopyFile {
    private String oldName,newName;
    private BufferedInputStream bis;
    private BufferedOutputStream bos;
    private byte[] bytes;

    public CopyFile(String oldName,String newName) throws FileNotFoundException {
        this.oldName = oldName;
        this.newName = newName;
        bis = new BufferedInputStream(new FileInputStream( oldName));
        bos = new BufferedOutputStream(new FileOutputStream(newName));
        bytes = new byte[1024];
    }

    public void copy() throws IOException {
        int len;
        while((len=bis.read(bytes))!=-1) {
            bos.write(bytes,0,len);
        }
        bis.close();
        bos.close();
        System.out.println("复制成功!");
    }


}
