import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class folderSize {  public static void main(String[] args) {
    File dir = new File(".\\src");

    try {
        System.out.println("Folder size: " + folderSize(dir));
    }catch (Exception e){
        e.printStackTrace();
    }
}
    public static long folderSize(File directory) {
        long length = 0;
        for (File file : directory.listFiles()) {
            if (file.isFile())
                length += file.length();
            else
                length += folderSize(file);
        }
        return length;
    }
}