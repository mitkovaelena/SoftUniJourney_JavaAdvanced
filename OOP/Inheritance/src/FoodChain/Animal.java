package FoodChain;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    protected List<Food> foodEaten = new ArrayList<>();

    public final void  eat(Food food) {
        foodEaten.add(food);
    }

    public final void eatAll(Food[] food) {
        for (Food f : food) {
        eat(f);
        }
    }

}
