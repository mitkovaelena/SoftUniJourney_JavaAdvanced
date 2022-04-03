package coffeeMachineExer;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {
    private List<Coffee> coffeesSold;
    private List<Coin> insertedCoins;

    public CoffeeMachine() {
        this.coffeesSold = new ArrayList<Coffee>();
        this.insertedCoins = new ArrayList<Coin>();;
    }

    public void buyCoffee(String size, String type){
        Coffee coffee = new Coffee(size,type);
        int currentSum = this.insertedCoins.stream().mapToInt(Coin::getValue).sum();

        if (currentSum >= coffee.getPrice()){
            this.insertedCoins.clear();
            coffeesSold.add(coffee);
        }
    }

	public void insertCoin(String c){
        Coin coin = Enum.valueOf(Coin.class, c.toUpperCase());
        this.insertedCoins.add(coin);
    }

	public Iterable<Coffee> coffeesSold(){
        return this.coffeesSold;
    }

}
