import java.io.*;
import java.util.ArrayList;

public class serializeArrayList {
    public static void main(String[] args) {
        final String objPath = ".\\10.output1.ser";

        ArrayList<Double> list = new ArrayList<>();
        list.add(5.0);
        list.add(5.1);
        list.add(5.2);
        list.add(5.3);
        list.add(5.4);
        list.add(5.5);
        list.add(5.6);
        list.add(5.7);
        list.add(5.8);
        list.add(5.9);


        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objPath))){
            oos.writeObject(list);
        } catch (IOException e){
            e.printStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(objPath))){
            ArrayList listLoaded = (ArrayList) ois.readObject();
            for(Object l : listLoaded) {
                System.out.print(l + " ");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
