package PizzaCalories;

public class Dough {
    private String flourType;
    private String backingTechnique;
    private Double weightInGrams;

    public Dough(String flourType, String backingTechnique, Double weightInGrams) {
        this.setFlourType(flourType);
        this.setBackingTechnique(backingTechnique);
        this.setWeightInGrams(weightInGrams);
    }

    private void setFlourType(String flourType) {
        if(!flourType.toLowerCase().equals("white") && !flourType.toLowerCase().equals("wholegrain") ){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBackingTechnique(String backingTechnique) {
        backingTechnique = backingTechnique.toLowerCase();
        if(!backingTechnique.equals("crispy") && !backingTechnique.equals("chewy") && !backingTechnique.equals("homemade") ){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.backingTechnique = backingTechnique;
    }

    private void setWeightInGrams(Double weightInGrams) {
        if(weightInGrams < 1 || weightInGrams > 200 ){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weightInGrams = weightInGrams;
    }

    public Double getCaloriesPerGram(){
        Double calories = this.weightInGrams * 2.0;
        if (this.flourType.toLowerCase().equals("white"))
            calories*=1.5;
        if (this.backingTechnique.toLowerCase().equals("crispy"))
            calories*=0.9;
        if (this.backingTechnique.toLowerCase().equals("chewy"))
            calories*=1.1;
        return calories;
    }
}
