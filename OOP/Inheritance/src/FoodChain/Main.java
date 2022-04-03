package FoodChain;

public class Main {
    public static void main(String[] args) {
        Food one = new Food();
        Predator predator = new Predator();
        predator.feed(one);
        predator.feed(one);
        predator.feed(one);
        predator.feed(one);
        predator.feed(one);

        System.out.println(predator.foodEaten.size());
    }
}
