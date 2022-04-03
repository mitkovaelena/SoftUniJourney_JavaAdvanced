package coffeeMachineExer;

public class Coffee {
    private CoffeeType coffeeType;
    private CoffeeSize coffeeSize;
    private int price;

    public Coffee(String coffeeSize, String coffeeType) {
        this.coffeeType = Enum.valueOf(CoffeeType.class, coffeeType.toUpperCase());
        this.coffeeSize = Enum.valueOf(CoffeeSize.class, coffeeSize.toUpperCase());
        this.price = this.coffeeSize.getPrice();
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.coffeeSize.toString() + " " + this.coffeeType.toString();
    }
}
