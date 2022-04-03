package FoodChain;

public class Predator extends Animal {
    private int health;

    public void feed(Food food){
        super.foodEaten.add(food);
        health++;
    }


}
