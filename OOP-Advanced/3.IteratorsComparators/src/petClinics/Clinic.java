package petClinics;

import java.util.Iterator;

public class Clinic implements Iterable<Integer> {
    private String name;
    private int numberOfRooms;
    private Pet[] pets;

    public Clinic(String name, int numberOfRooms) {
        this.name = name;
        this.setNumberOfRooms(numberOfRooms);
        this.pets = new Pet[this.numberOfRooms];

    }

    public void setNumberOfRooms(int numberOfRooms) {
        if (numberOfRooms % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.numberOfRooms = numberOfRooms;
    }

    public boolean addPet(Pet pet) {
        Iterator iterator = new AddIterator();

        while (iterator.hasNext()) {
            Integer index = (Integer) iterator.next();
            if (this.pets[index] == null) {
                this.pets[index] = pet;
                return true;
            }
        }
        return false;
    }

    public boolean release() {
        Iterator iterator = new ReleaseIterator();

        while (iterator.hasNext()) {
            Integer index = (Integer) iterator.next();
            if (this.pets[index] != null) {
                this.pets[index] = null;
                return true;
            }
        }
        return false;
    }

    public boolean hasEmptyRooms() {
        for (int i = 0; i < this.pets.length; i++) {
            if (this.pets[i] == null) return true;
        }
        return false;
    }

    public String print(Integer... varargs) {
        if (varargs.length == 1) {
            if (this.pets[varargs[0] - 1] != null) {
                return this.pets[varargs[0] - 1].toString();
            }
            return "Room empty";
        }
        StringBuilder output = new StringBuilder("");
        for (int i = 0; i < this.pets.length; i++) {
            if (this.pets[i] != null) {
                output.append(this.pets[i].toString() + "\n");
            } else {
                output.append("Room empty" + "\n");
            }
        }
        return output.toString().trim();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new ReleaseIterator();
    }

    private final class AddIterator implements Iterator<Integer> {
        private int counter;
        private int step;

        public AddIterator() {
            this.counter = 0;
            this.step = 0;
        }

        @Override
        public boolean hasNext() {
            return pets.length > this.counter;
        }

        @Override
        public Integer next() {
            this.counter++;
            if (this.step != 0) {
                if (this.counter % 2 == 0) {
                    return pets.length / 2 - this.step;
                }
            }
            return pets.length / 2 + this.step++;
        }

    }

    private final class ReleaseIterator implements Iterator<Integer> {
        private int counter;
        private boolean reachedEnd;

        public ReleaseIterator() {
            this.counter = pets.length / 2;
            reachedEnd = false;
        }

        @Override
        public boolean hasNext() {
            return ((pets.length / 2) != this.counter || !this.reachedEnd) && this.counter < pets.length;
        }

        @Override
        public Integer next() {
            if (this.counter == pets.length - 1) {
                this.counter = 0;
                this.reachedEnd = true;
                return pets.length - 1;
            }
            return counter++;
        }

    }

}
