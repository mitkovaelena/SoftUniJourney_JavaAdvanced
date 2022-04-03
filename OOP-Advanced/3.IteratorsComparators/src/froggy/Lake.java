package froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake<Integer> implements Iterable<Integer> {
    private List<Integer> ints = new ArrayList<>();

    public Lake(List<Integer> ints) {
        this.ints = ints;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<Integer> {
        private int counter;

        public Frog() {
            this.counter = -2;
        }

        @Override
        public boolean hasNext() {
            if (ints.size() == 1 && this.counter == 0) {
                return false;
            }
            if (this.counter % 2 != 0) {
                return ints.size() > this.counter + 2;
            }
            if (ints.size() <= this.counter + 2) {
                this.counter = -1;
            }
            return true;

        }

        @Override
        public Integer next() {
            return ints.get(this.counter += 2);

        }

    }
}
