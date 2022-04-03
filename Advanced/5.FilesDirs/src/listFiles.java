import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;

public class listFiles {
    public static void main(String[] args) {
        File dir = new File(".\\Files-and-Streams");
        ArrayDeque<File> fileQueue = new ArrayDeque<>();
        fileQueue.offer(dir);
        int counter = 0;

        while (!fileQueue.isEmpty()){
            File crntDir = fileQueue.poll();
            File[] nestedFiles = crntDir.listFiles();
            System.out.println(crntDir.getName());
            counter++;
            for(File f : nestedFiles){
                if(f.isDirectory()){
                    fileQueue.offer(f);
                }
            }
        }
        System.out.println(counter + " folders");
    }
}
