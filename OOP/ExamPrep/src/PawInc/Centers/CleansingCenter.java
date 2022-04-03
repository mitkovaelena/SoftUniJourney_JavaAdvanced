package PawInc.Centers;

import PawInc.Animals.Animal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CleansingCenter extends Center {
    private List<String> cleansedAnimals = new ArrayList<String>();

    public CleansingCenter(String name) {
        super(name);
    }

    public void cleanseAnimals(){
        for(Animal animal : super.getStoredAnimals()){
            animal.cleanse();
            this.addCleansedAnimal(animal.getName());
            returnAnimalToAdoptionCenter(animal, animal.getAdoptionCenter());
        }
        super.setStoredAnimals(new ArrayList<>());
    }

    private void returnAnimalToAdoptionCenter(Animal animal, AdoptionCenter adoptionCenter){
        adoptionCenter.addAnimal(animal);
    }

    public List<String> getCleansedAnimals() {
        return Collections.unmodifiableList(cleansedAnimals);
    }

    public void addCleansedAnimal(String animalName) {
        this.cleansedAnimals.add(animalName);
    }
}
