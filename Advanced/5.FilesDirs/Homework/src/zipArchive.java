import java.io.*;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class zipArchive {
    public static void main(String[] args) {
        final String inFile1 = ".\\01.input1.txt";
        final String inFile2 = ".\\01.input2.txt";
        final String inFile3 = ".\\03.input2.txt";
        final String outFile = ".\\11.output1.zip";


        try(FileInputStream fis1 = new FileInputStream(inFile1);
            FileInputStream fis2 = new FileInputStream(inFile2);
            FileInputStream fis3 = new FileInputStream(inFile3);
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(outFile))
        ){
            zos.putNextEntry(new ZipEntry("01.input1.txt"));
            int length1;
            while((length1=fis1.read())>0)
            {
                zos.write(length1);
            }
            zos.putNextEntry(new ZipEntry("01.input2.txt"));
            int length2;
            while((length2=fis2.read())>0)
            {
                zos.write(length2);
            }
            zos.putNextEntry(new ZipEntry("03.input2.txt"));
            int length3;
            while((length3=fis3.read())>0)
            {
                zos.write(length3);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
