import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class writeFile {
    public static void main(String[] args) {
        String inPath = ".\\input1.txt";
        String outPath = ".\\output1.txt";
        HashSet skipChars = new HashSet();
        Collections.addAll(skipChars, ',', '.', '!', '?');

        try (FileInputStream fis = new FileInputStream(inPath);FileOutputStream fos = new FileOutputStream(outPath)) {
            int oneByte = fis.read();
            while (oneByte>=0){
                if(!skipChars.contains((char)oneByte)) {
                    fos.write(oneByte);
                }
                oneByte = fis.read();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
