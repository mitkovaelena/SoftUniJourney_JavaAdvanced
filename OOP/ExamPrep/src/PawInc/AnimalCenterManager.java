package PawInc;

import PawInc.Animals.Animal;
import PawInc.Animals.Cat;
import PawInc.Animals.Dog;
import PawInc.Centers.AdoptionCenter;
import PawInc.Centers.CastrationCenter;
import PawInc.Centers.CleansingCenter;

import java.text.Collator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class AnimalCenterManager {
    private Map<String,CleansingCenter> cleansingCenters ;
    private Map<String,AdoptionCenter> adoptionCenters;
    private Map<String,CastrationCenter> castrationCenters;
    private Map<String,Animal> animals;
    private TreeSet<String> adoptedAnimals;
    private TreeSet<String> cleansedAnimals;
    private TreeSet<String> castratedAnimals;

    public AnimalCenterManager() {
        this.cleansingCenters = new HashMap<String, CleansingCenter>();
        this.adoptionCenters = new HashMap<String, AdoptionCenter>();
        this.castrationCenters = new HashMap<>();
        this.animals = new HashMap<String, Animal>();
        this.adoptedAnimals = new TreeSet<>();
        this.cleansedAnimals = new TreeSet<>();
        this.castratedAnimals =new TreeSet<>();
    }


    public void registerCleansingCenter(String name){
        CleansingCenter newCleansingCenter = new CleansingCenter(name);
        cleansingCenters.put(name, newCleansingCenter);
    }

	public void registerAdoptionCenter(String name){
        AdoptionCenter newAdoptionCenter = new AdoptionCenter(name);
        adoptionCenters.put(name, newAdoptionCenter);
    }

	public  void registerDog(String name, int age, int learnedCommands, String adoptionCenterName){
        Dog newDog = new Dog(name,age,learnedCommands);
        newDog.sendToAdoptionCenter(adoptionCenters.get(adoptionCenterName));
        animals.put(name, newDog);
    }
	public void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName){
        Cat newCat = new Cat(name,age,intelligenceCoefficient);
        newCat.sendToAdoptionCenter(adoptionCenters.get(adoptionCenterName));
        animals.put(name, newCat);
    }
	public void sendForCleansing(String adoptionCenterName, String cleansingCenterName){
	    adoptionCenters.get(adoptionCenterName).sendAnimalsToCleansingCenter(cleansingCenters.get(cleansingCenterName));
    }

	public void cleanse(String cleansingCenterName){
        cleansingCenters.get(cleansingCenterName).cleanseAnimals();
    }

	public void adopt(String adoptionCenterName){
	    adoptionCenters.get(adoptionCenterName).adoptAllAnimals();
    }

    public void registerCastrationCenter(String name){
        CastrationCenter newCastrationCenter = new CastrationCenter(name);
        castrationCenters.put(name, newCastrationCenter);
    }

    public void sendForCastration(String adoptionCenterName, String castrationCenterName){
        adoptionCenters.get(adoptionCenterName).sendAnimalsToCastrationCenter(castrationCenters.get(castrationCenterName));
    }

    public void castrate(String castrationCenterName){
        castrationCenters.get(castrationCenterName).castrateAnimals();
    }

    public void castrationStatistics(){
        for (String ac : castrationCenters.keySet()){
            for(String a : castrationCenters.get(ac).getCastratedAnimals()){
                castratedAnimals.add(a);
            }
        }
        System.out.printf("Paw Inc. Regular Castration Statistics\n" +
                        "Castration Centers: %d\n" +
                        "Castrated Animals: %s\n" ,
                castrationCenters.size(),
                castratedAnimals.size()>0 ? castratedAnimals.toString().replaceAll("[\\[\\]]", "") : "None");
    }

	public void printStatistics(){
        int animalsAwaitingAdoption = 0;
        int animalsAwaitingCleansing = 0;

	    for (String ac : adoptionCenters.keySet()){
	        animalsAwaitingAdoption += adoptionCenters.get(ac).getStoredAnimals().size();
	        for(String a : adoptionCenters.get(ac).getAdoptedAnimals()){
	            adoptedAnimals.add(a);
            }
        }

        for (String cc : cleansingCenters.keySet()){
            animalsAwaitingCleansing += cleansingCenters.get(cc).getStoredAnimals().size();
            for(String a : cleansingCenters.get(cc).getCleansedAnimals()){
                cleansedAnimals.add(a);
            }
        }
        System.out.printf("Paw Incorporative Regular Statistics\n" +
                "Adoption Centers: %d\n" +
                "Cleansing Centers: %d\n" +
                "Adopted Animals: %s\n" +
                "Cleansed Animals: %s\n" +
                "Animals Awaiting Adoption: %d\n" +
                "Animals Awaiting Cleansing: %d\n",
                adoptionCenters.size(), cleansingCenters.size(),
                adoptedAnimals.size()>0 ? adoptedAnimals.stream().sorted(Collator.getInstance()).collect(Collectors.toList()).toString().replaceAll("[\\[\\]]", "") : "None",
                cleansedAnimals.size()> 0 ?cleansedAnimals.stream().sorted(Collator.getInstance()).collect(Collectors.toList()).toString().replaceAll("[\\[\\]]", "") : "None", animalsAwaitingAdoption,animalsAwaitingCleansing);
    }

}
