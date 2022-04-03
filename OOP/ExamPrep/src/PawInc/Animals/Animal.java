package PawInc.Animals;

import PawInc.Centers.AdoptionCenter;

public abstract class Animal {
    private String name;
    private int age;
    private boolean isCleansed;
    private boolean isCastrated;
    private AdoptionCenter adoptionCenter;

    protected Animal() {

    }

    protected Animal(String name, int age) {
        this.setName(name);
        this.setAge(age);
        this.setCleansed(false);
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    protected void setAge(int age) {
        this.age = age;
    }

    public boolean isCleansed() {
        return isCleansed;
    }

    protected void setCleansed(boolean cleansed) {
        this.isCleansed = cleansed;
    }


    public boolean isCastrated() {
        return isCastrated;
    }

    protected void setCastrated(boolean castrated) {
        isCastrated = castrated;
    }


    public void cleanse(){
        this.setCleansed(true);
    }


    public void castrate(){
        this.setCastrated(true);
    }

    public AdoptionCenter getAdoptionCenter() {
        return adoptionCenter;
    }

    public void setAdoptionCenter(AdoptionCenter adoptionCenter) {
        this.adoptionCenter = adoptionCenter;
        adoptionCenter.addAnimal(this);
    }

    public void sendToAdoptionCenter(AdoptionCenter adoptionCenter) {
        this.setAdoptionCenter(adoptionCenter);
    }
}
