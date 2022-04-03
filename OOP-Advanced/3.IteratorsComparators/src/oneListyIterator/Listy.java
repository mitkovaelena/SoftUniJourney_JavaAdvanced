package oneListyIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Listy implements Iterable<String> {
    private List<String> container = new ArrayList<>();
    private ListyIterator iterator;

    public Listy(String... elements) {
        for(String e : elements){
            this.container.add(e);
        }
        this.iterator = this.iterator();
    }

    @Override
    public ListyIterator iterator() {
        return new ListyIterator();
    }


    public boolean move(){
        if(this.iterator.hasNext()){
            this.iterator.next();
            return true;
        }
        return false;
    }

    public void print(){
        if(!this.container.isEmpty()) {
            System.out.println(this.iterator.crnt());
        }
        else {
            System.out.println("Invalid Operation!");
        }
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public void printAll(){
        System.out.println(this.container.toString().replaceAll("[\\[\\],]", ""));
    }


    private final class ListyIterator implements Iterator<String>{
        private int counter;

        public ListyIterator() {
            this.counter = 0;
        }

        @Override
        public boolean hasNext() {
            return container.size() > this.counter+1;
        }

        @Override
        public String next(){
            return container.get(this.counter++);
        }

        public String crnt(){
            return container.get(this.counter);
        }

    }

}
