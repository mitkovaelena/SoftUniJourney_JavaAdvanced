package ShoppingSpree;

import java.util.LinkedList;
import java.util.List;

public class Person {
    private String name;
    private Double money;
    private List<String> bagOfProducts;

    public Person(String name, Double money) {
        this.setName(name);
        this.setMoney(money);
        this.bagOfProducts = new LinkedList<>();
    }

    public String getBagOfProducts() {
        if(this.bagOfProducts.isEmpty()) return "Nothing bought";
        return bagOfProducts.toString().replaceAll("[\\[\\]]", "");
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()||name.replaceAll(" ", "").isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setMoney(Double money) {
        if(money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product p){
        if(p.getCost() <= this.money){
            this.money -= p.getCost();
            System.out.println(this.name + " bought " + p.getName());
            this.bagOfProducts.add(p.getName());
        }
        else {
            System.out.println(this.name + " can't afford " + p.getName());
        }
    }
}
