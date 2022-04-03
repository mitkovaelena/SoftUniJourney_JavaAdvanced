package bookLibrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Book implements Comparable<Book>{
    private String title;
    private int year;
    private List<String> authors = new ArrayList<>();

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return Collections.unmodifiableList(authors);
    }

    private void setAuthors(String... authors) {
            this.authors= Arrays.asList(authors);
    }

    @Override
    public int compareTo(Book book) {
        int compared = book.getTitle().compareTo(this.getTitle());
        return compared == 0 ?  book.getYear() - this.getYear() : compared;

    }

    @Override
    public String toString() {
        return this.getTitle() + ' ' + this.getYear();
    }
}
