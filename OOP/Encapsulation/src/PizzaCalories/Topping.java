package PizzaCalories;

public class Topping {
    private String type;
    private Double weightInGrams;

    public Topping(String type, Double weightInGrams) {
        this.setType(type);
        this.setWeightInGrams(weightInGrams);
    }

    private void setType(String type) {
        if(!type.toLowerCase().equals("meat") && !type.toLowerCase().equals("veggies") && !type.toLowerCase().equals("cheese") && !type.toLowerCase().equals("sauce") ){
            throw new IllegalArgumentException("Cannot place " + type + " on top of your pizza.");
        }
        this.type = type;
    }

    private void setWeightInGrams(Double weightInGrams) {
        if(weightInGrams < 1 || weightInGrams > 50 ){
            throw new IllegalArgumentException(type + " weight should be in the range [1..50].");
        }
        this.weightInGrams = weightInGrams;
    }

    public Double getCaloriesPerGram(){
        Double calories = this.weightInGrams * 2.0;
        if (this.type.toLowerCase().equals("meat"))
            calories*=1.2;
        if (this.type.toLowerCase().equals("veggies"))
            calories*=0.8;
        if (this.type.toLowerCase().equals("cheese"))
            calories*=1.1;
        if (this.type.toLowerCase().equals("sauce"))
            calories*=0.9;
        return calories;
    }

}
