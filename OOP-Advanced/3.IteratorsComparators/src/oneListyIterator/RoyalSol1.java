package oneListyIterator;

import java.util.Iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class RoyalSol1 {
    public static void main(String[] args) {
        BiPredicate<Integer, Integer> hasNext = (s, c) -> s > c + 1;
        BiFunction<List<String>, Integer, String> next = List::get;
        Listy1 listy = new Listy1(hasNext, next, "a", "c", "b", "d");
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


class Listy1 implements Iterable<String> {
    private List<String> container = new ArrayList<>();
    private BiPredicate<Integer, Integer> hasNext;
    private BiFunction<List<String>, Integer, String> next;
    private int counter;

    public Listy1(BiPredicate<Integer, Integer> hasNext, BiFunction<List<String>, Integer, String> next, String... elements) {
        this.hasNext = hasNext;
        this.next = next;
        this.counter = 0;
        for (String e : elements) {
            this.container.add(e);
        }
    }

    @Override
    public ListyIterator iterator() {
        return new ListyIterator();
    }

    public boolean move() {
        if (this.hasNext()) {
            return this.next.apply(this.container, this.counter++) != null;
        }

        return false;
    }

    public void print() {
        if (!this.container.isEmpty()) {
            System.out.println(this.container.get(this.counter));
        } else {
            System.out.println("Invalid Operation!");
        }
    }

    public boolean hasNext() {
        return this.hasNext.test(this.container.size(), this.counter);
    }

    public void printAll() {
        System.out.println(this.container.toString().replaceAll("[\\[\\],]", ""));
    }


    private final class ListyIterator implements Iterator<String> {
        private int counter;

        public ListyIterator() {
            this.counter = -1;
        }

        @Override
        public boolean hasNext() {
            return hasNext.test(container.size(), this.counter++);
        }

        @Override
        public String next() {
            return next.apply(container, this.counter);
        }

        public String crnt() {
            return container.get(this.counter);
        }

    }
}
