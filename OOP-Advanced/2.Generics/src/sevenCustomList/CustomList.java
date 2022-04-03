package sevenCustomList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomList<T extends Comparable> {
    private List<T> container;

    public CustomList() {
        this.container = new ArrayList<T>();
    }

    public void add(T elem){
        this.container.add(elem);
    }

    public T remove(int index){
        return this.container.remove(index);
    }

    public boolean contains(T elem){
        return this.container.contains(elem);
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

    public T getMin(){
        if(this.container.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return this.container.stream().sorted().collect(Collectors.toList()).get(0);
    }

    public T getMax(){
        if(this.container.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return this.container.stream().sorted().collect(Collectors.toList()).get(this.container.size()-1);
    }

    public void sort(){
        if(this.container.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.container = this.container.stream().sorted().collect(Collectors.toList());
    }

    @Override
    public String toString() {
        String output = "";
        Iterator itr = this.container.iterator();

        while(itr.hasNext()) {
            output += itr.next().toString() + "\n";
        }
        return output.trim();
    }
}
