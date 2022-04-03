package P01_ExtendedArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class  ExtendedArrayList<T extends Comparable<T>> extends ArrayList<T>{

    public T min(){
        T min = null;
        Iterator<T> iterator = super.iterator();
        while (iterator.hasNext()){
            T next = iterator.next();
            if(min == null || next.compareTo(min) < 0 ){
                min = next;
            }
        }
        return min;
    }

    public T max(){
        T max = null;
        Iterator<T> iterator = super.iterator();
        while (iterator.hasNext()){
            T next = iterator.next();
            if(max == null || next.compareTo(max) > 0 ){
                max = next;
            }
        }
        return max;
    }

}
