package oneJar;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<T> {
    private Deque<T> container;

    public Jar() {
        this.container = new ArrayDeque<T>();
    }

    public void add(T element){
        this.container.push(element);
    }

    public T remove(){
       return this.container.pop();
    }
}
