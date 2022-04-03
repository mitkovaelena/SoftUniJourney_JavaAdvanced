package bookLibrary;

import java.util.Iterator;

public class Library<Book> implements Iterable<Book> {
    private Book[] books ;

    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator(){
        return new LibIterator();
    }

    private final class LibIterator implements Iterator<Book>{
        private int counter;

        public LibIterator(){
            this.counter = 0;
        }

        @Override
        public boolean hasNext(){
            return books.length > this.counter;
        }

        @Override
        public Book next(){
            return books[this.counter++];
        }

    }
}
