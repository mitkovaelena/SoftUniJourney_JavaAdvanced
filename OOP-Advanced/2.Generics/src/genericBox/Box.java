package genericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private T input;
    private List<T> container;

    public Box() {
        this.container = new ArrayList<T>();
    }

    public Box(T input) {
        this.input = input;
    }

    public void addElementInBox(T elem){
        this.container.add(elem);
    }

    public void swap(Integer ind1, Integer ind2){
        T temp = this.container.get(ind1);
        this.container.set(ind1, this.container.get(ind2));
        this.container.set(ind2, temp);
    }

    public Integer countGreaterThan(T elem){
        int count = 0;
        for (T element : this.container) {
            if (element.compareTo(elem) > 0) count++;
        }
        return count;
    }

    @Override
    public String toString() {
        String output = "";
        for (T elem : this.container ) {
           output += elem.getClass().getName()+": " + elem.toString() + "\n";
        }
        return output;
    }
}
