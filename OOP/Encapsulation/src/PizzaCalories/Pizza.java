package PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name) {
        this.name = name;
        this.toppings = new ArrayList<>();
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public String getName() {
        return name;
    }

    public Double getCalories(){
        Double calories = this.dough.getCaloriesPerGram();

        for(Topping t : this.toppings){
            calories += t.getCaloriesPerGram();
        }

        return calories;
    }

}
