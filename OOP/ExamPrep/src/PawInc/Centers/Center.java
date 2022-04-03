package PawInc.Centers;

import PawInc.Animals.Animal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Center {
    private String name;
    private List<Animal> storedAnimals;

    protected Center() {
    }

    protected Center(String name) {
        this.setName(name);
        this.setStoredAnimals(new ArrayList<>());
    }

    private void setName(String name) {
        this.name = name;
    }

    public List<Animal> getStoredAnimals() {
        return Collections.unmodifiableList(storedAnimals);
    }

    protected void setStoredAnimals(List<Animal> storedAnimals) {
        this.storedAnimals = storedAnimals;
    }

    public void addAnimal(Animal animal){
        this.storedAnimals.add(animal);
    }
}
