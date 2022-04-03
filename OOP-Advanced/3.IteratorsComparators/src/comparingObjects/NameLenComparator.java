package comparingObjects;

import java.util.Comparator;

public class NameLenComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getName().length() - p2.getName().length() != 0 ? p1.getName().length() - p2.getName().length():
                (p1.getName().toLowerCase()).charAt(0) - (p2.getName().toLowerCase()).charAt(0);
    }
}
