package eightTuple;

public class Tuple<E,T, S> {
    private E item1;
    private T item2;
    private S item3;

    public Tuple(E item1, T item2, S item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    @Override
    public String toString() {
        return this.item1.toString() +" -> " + this.item2.toString() +" -> " + this.item3.toString();
    }
}
