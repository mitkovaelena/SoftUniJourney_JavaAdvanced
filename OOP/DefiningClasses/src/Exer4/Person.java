package Exer4;


import java.util.ArrayList;

class Person{
    String name;
    String company;
    String car;
    ArrayList<String> parents;
    ArrayList<String> children;
    ArrayList<String> pokemons;

    Person (String name){
        this.name = name;
        this.company = "";
        this.car = "";
        this.parents = new ArrayList<String>();
        this.children = new ArrayList<String>();
        this.pokemons = new ArrayList<String>();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public ArrayList<String> getParents() {
        return parents;
    }

    public void setParents(ArrayList<String> parents) {
        this.parents = parents;
    }

    public ArrayList<String> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<String> children) {
        this.children = children;
    }

    public ArrayList<String> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<String> pokemons) {
        this.pokemons = pokemons;
    }

    public String getName() {
        return name;
    }
}
