import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;

public class copyBytes {
    public static void main(String[] args) {
        String inPath = ".\\input1.txt";
        String outPath = ".\\output2.txt";

        try (FileInputStream fis = new FileInputStream(inPath); FileOutputStream fos = new FileOutputStream(outPath)) {
            int oneByte = fis.read();
            while (oneByte>=0){
                if(oneByte == ' ' || oneByte == '\n') {
                    fos.write(oneByte);
                }else {
                    String temp = String.valueOf(oneByte);
                    for(char c : temp.toCharArray()) {
                        fos.write(c);
                    }
                }
                oneByte = fis.read();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
