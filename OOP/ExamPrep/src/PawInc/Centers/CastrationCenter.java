package PawInc.Centers;

import PawInc.Animals.Animal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CastrationCenter extends Center{
    private List<String> castratedAnimals = new ArrayList<String>();

    public CastrationCenter(String name) {
        super(name);
    }
    public void castrateAnimals(){
        for(Animal animal : super.getStoredAnimals()){
            animal.castrate();
            this.addCastratedAnimal(animal.getName());
            returnAnimalToAdoptionCenter(animal, animal.getAdoptionCenter());
        }
        super.setStoredAnimals(new ArrayList<>());
    }

    private void returnAnimalToAdoptionCenter(Animal animal, AdoptionCenter adoptionCenter){
        adoptionCenter.addAnimal(animal);
    }

    public List<String> getCastratedAnimals() {
        return Collections.unmodifiableList(castratedAnimals);
    }

    public void addCastratedAnimal(String animalName) {
        this.castratedAnimals.add(animalName);
    }

    @Override
    public List<Animal> getStoredAnimals() {
        return Collections.unmodifiableList(super.getStoredAnimals());
    }

    @Override
    protected void setStoredAnimals(List<Animal> storedAnimals) {
        super.setStoredAnimals(storedAnimals);
    }

    public void setCastratedAnimals(List<String> castratedAnimals) {
        this.castratedAnimals = castratedAnimals;
    }
}
