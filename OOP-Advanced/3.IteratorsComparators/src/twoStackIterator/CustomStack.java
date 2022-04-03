package twoStackIterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CustomStack<Integer> implements Iterable<Integer> {
private List<Integer> container;
private StackIterator iterator;

    public CustomStack() {
        this.container = new LinkedList<>();
        this.iterator = this.iterator();
    }

    public void push(Integer element){
            this.container.add(element);
    }

    public boolean pop(){
        if(!this.container.isEmpty()) {
            this.container.remove(this.container.size()-1);
            return true;
        }
       return false;
    }

    @Override
    public StackIterator iterator() {
        return new StackIterator();
    }

    private final class StackIterator implements Iterator<Integer>{
        private int counter;

        public StackIterator() {
            this.counter = container.size()-1;
        }

        @Override
        public boolean hasNext() {
            return 0 <= this.counter;
        }

        @Override
        public Integer next(){
            return container.get(this.counter--);
        }

    }

}
