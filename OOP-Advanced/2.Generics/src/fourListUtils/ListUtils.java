package fourListUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListUtils {

    public static <T> T getMin(List<T> list){
        if(list.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return list.stream().sorted().collect(Collectors.toList()).get(0);
    }

    public static <T> T getMax(List<T> list){
        if(list.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return list.stream().sorted().collect(Collectors.toList()).get(list.size()-1);
    }

    public static List<Integer> getNullIndices(List<?> list){
        List<Integer> nulls = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) == null){
                nulls.add(i);
            }
        }

        return nulls;
    }

    public static <T> void flatten(List<? super T> destination, List<List<? extends T>> source){
        for(List<? extends T> subList : source){
            destination.addAll(subList);
        }
    }

    public static <T> void addAll(List<? super T> destination, List<? extends T> source){
            destination.addAll(source);
    }
}
