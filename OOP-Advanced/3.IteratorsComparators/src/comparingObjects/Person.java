package comparingObjects;

public class Person implements Comparable<Person>{
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }

    @Override
    public int compareTo(Person p) {
        if (this.getName().compareTo(p.getName()) == 0) {
            return this.getAge() - p.getAge();
        }
        return this.getName().compareTo(p.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return this.getAge() == person.getAge() && this.getName().equals(person.getName());
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 31 * result + this.getAge();
        result = 31 * result + this.getName().hashCode();

        return result;
    }

    @Override
    public String toString() {
        return name + ' ' + age ;
    }
}
