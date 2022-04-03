package oneListyIterator;

import java.util.Iterator;

import java.util.ArrayList;
import java.util.List;

public class RoyalSol2 {
    public static void main(String[] args) {
        Listy2 listy = new Listy2("a", "c", "b", "d");
        listy.printAll();
        listy.printAll();
        listy.print();
        for (String s : listy) {
            System.out.print(s + " ");
        }
        System.out.println();
        while (listy.hasNext()) {
            listy.print();
            listy.move();
        }
    }
}

class ElementAwareContainer<T> {
    private int counter;
    private List<T> container;

    public ElementAwareContainer() {
        this.counter = 0;
        this.container = new ArrayList<T>();
    }

    protected void init(int counter, List<T> container) {
        this.counter = counter;
        this.container = container;
    }

    public boolean hasNext() {
        return this.container.size() > this.counter+1;
    }

    public T next() {
        return this.container.get(this.counter++);
    }

    public T current() {
        return this.container.get(this.counter);
    }
}

class Listy2 extends ElementAwareContainer<String> implements Iterable<String> {
    private List<String> container = new ArrayList<>();
    private int counter;

    public Listy2(String... elements) {
        this.counter = 0;
        for(String e : elements){
            this.container.add(e);
        }
        this.init(this.counter, this.container);
    }

    @Override
    public ListyIterator iterator() {
        return new ListyIterator();
    }

    public boolean move(){
        if (this.hasNext()) {
            return this.next() != null;
        }

        return false;
    }

    public void print(){
        if(!this.container.isEmpty()) {
            System.out.println(this.current());
        }
        else {
            System.out.println("Invalid Operation!");
        }
    }

    public void printAll(){
        System.out.println(this.container.toString().replaceAll("[\\[\\],]", ""));
    }


    private final class ListyIterator extends ElementAwareContainer<String> implements Iterator<String> {
        private int counter;

        public ListyIterator() {
            this.counter = 0;
            this.init(this.counter, container);
        }

        public String crnt(){
            return container.get(this.counter);
        }

    }

}
