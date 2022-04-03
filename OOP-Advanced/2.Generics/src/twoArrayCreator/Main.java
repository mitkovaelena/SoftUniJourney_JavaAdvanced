package twoArrayCreator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String [] array = ArrayCreator.create(String.class, 6, "fhdj");
        System.out.println(Arrays.toString(array));
    }
}
