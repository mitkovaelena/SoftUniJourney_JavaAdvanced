package fourListUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        List<Double> doubles = new ArrayList<>();
        Collections.addAll(integers, 1,2,4,5,7);
        Collections.addAll(doubles, 1.2,4.0,5.7);

        List<? super Number> src= new ArrayList<>();
        src.addAll(integers);

        List<? super Number> dest = new ArrayList<>();
        ListUtils.addAll(dest,integers);
        System.out.println(dest);


    }
}
