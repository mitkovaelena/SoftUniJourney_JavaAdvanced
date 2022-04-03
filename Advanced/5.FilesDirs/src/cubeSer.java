import java.io.*;

public class cubeSer {
    public static void main(String[] args) {
        final String objPath = ".\\object.ser";

        Cube cube = new Cube();
        cube.color = "green";
        cube.width = 5.0;
        cube.height = 5.1;
        cube.depth = 5.2;

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objPath))){
            oos.writeObject(cube);
        } catch (IOException e){
            e.printStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(objPath))){
            Cube cubeLoaded = (Cube) ois.readObject();
            System.out.println(cubeLoaded.color);
            System.out.println(cubeLoaded.width);
            System.out.println(cubeLoaded.height);
            System.out.println(cubeLoaded.depth);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
