import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class copyPicture {
    public static void main(String[] args) {
        final String inPath = ".\\09.input1.jpg";
        final String outPath = ".\\09.output1.jpg";

        try (FileInputStream fis = new FileInputStream(inPath); FileOutputStream fos = new FileOutputStream(outPath);) {
            int oneByte = fis.read();

            while (oneByte >= 0) {
                fos.write(oneByte);
                oneByte = fis.read();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
