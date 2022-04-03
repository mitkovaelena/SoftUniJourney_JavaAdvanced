package ShoppingSpree;

public class Product {
    private String name;
    private Double cost;

    public Product(String name, Double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    public String getName() {
        return name;
    }

    public Double getCost() {
        return cost;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()|| name.replaceAll(" ", "").isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setCost(Double cost) {
        if(cost < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.cost = cost;
    }
}
