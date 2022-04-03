package linkedListTraversal;

import java.util.ArrayList;
import java.util.Iterator;

public class CustomLinkedList<T> implements Iterable<T> {
    private ArrayList<T> linkedList;

    public CustomLinkedList() {
        this.linkedList = new ArrayList<T>();
    }

    public void add(T element) {
        this.linkedList.add(element);
    }

    public void remove(T element){
        for (int i = 0; i < this.linkedList.size(); i++) {
            T currentElement = this.linkedList.get(i);
            if (currentElement.equals(element)) {
                this.linkedList.remove(i);
                return;
            }
        }
    }

    public int getSize(){
        return this.linkedList.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private final class ListIterator implements Iterator<T>{
        private int counter;

        public ListIterator(){
            this.counter = 0;
        }

        @Override
        public boolean hasNext(){
            return linkedList.size() > this.counter;
        }

        @Override
        public T next(){
            return linkedList.get(this.counter++);
        }

    }
}
