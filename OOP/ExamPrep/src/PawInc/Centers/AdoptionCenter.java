package PawInc.Centers;

import PawInc.Animals.Animal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AdoptionCenter extends Center {
private List<String> adoptedAnimals = new ArrayList<String>();

    public AdoptionCenter(String name) {
        super(name);
    }

    public void sendAnimalsToCleansingCenter(CleansingCenter cleansingCenter){
        ArrayList<Animal> uncleansedAnimals = super.getStoredAnimals().stream().filter(x -> !x.isCleansed()).collect(Collectors.toCollection(ArrayList::new));

        for(Animal a : uncleansedAnimals) {
            cleansingCenter.addAnimal(a);
        }
        this.setStoredAnimals(new ArrayList<>());
    }

    public void sendAnimalsToCastrationCenter(CastrationCenter castrationCenter){
        ArrayList<Animal> uncastratedAnimals = super.getStoredAnimals().stream().filter(x -> !x.isCastrated()).collect(Collectors.toCollection(ArrayList::new));

        for(Animal a : uncastratedAnimals) {
            castrationCenter.addAnimal(a);
        }
        this.setStoredAnimals(new ArrayList<>());
    }

    public void adoptAllAnimals(){
        this.setAdoptedAnimals(super.getStoredAnimals().stream().filter(x -> x.isCleansed()).map(x -> x.getName()).collect(Collectors.toCollection(ArrayList::new)));
        super.setStoredAnimals(super.getStoredAnimals().stream().filter(x -> !x.isCleansed()).collect(Collectors.toCollection(ArrayList::new)));
    }

    public void setAdoptedAnimals(ArrayList<String> adoptedAnimals) {
        this.adoptedAnimals = adoptedAnimals;
    }

    public List<String> getAdoptedAnimals() {
        return Collections.unmodifiableList(this.adoptedAnimals);
    }

    public void setAdoptedAnimals(List<String> adoptedAnimals) {
        this.adoptedAnimals = adoptedAnimals;
    }

    @Override
    public List<Animal> getStoredAnimals() {
        return Collections.unmodifiableList(super.getStoredAnimals());
    }

    @Override
    protected void setStoredAnimals(List<Animal> storedAnimals) {
        super.setStoredAnimals(storedAnimals);
    }
}
