package PizzaCalories;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] firstLine = scan.readLine().split("\\s+");
            String[] secondLine = {""};
            if (firstLine[0].equals("Dough")) {
                String flourType = firstLine[1];
                String bakingTech = firstLine[2];
                double doughWeight = Double.valueOf(firstLine[3]);
                Dough dough = new Dough(flourType, bakingTech, doughWeight);
                secondLine = scan.readLine().split("\\s+");
                System.out.printf("%.2f\n",dough.getCaloriesPerGram());
            }
            if(secondLine[0].equals("END")){
                return;
            }else if(secondLine[0].equals("Topping")){
                String toppingType = secondLine[1];
                double toppingWeight = Double.valueOf(secondLine[2]);
                Topping topping = new Topping(toppingType, toppingWeight);
                System.out.printf("%.2f\n",topping.getCaloriesPerGram());
                return;
            }
            String pizzaName = firstLine[1];
            int numberOfToppings = Integer.valueOf(firstLine[2]);
            if(numberOfToppings <0 || numberOfToppings > 10){
                System.out.println("Number of toppings should be in range [0..10].");
                return;
            }
            Pizza pizza = new Pizza(pizzaName);

            String[] doughData = scan.readLine().split("\\s+");
            String flourType = doughData[1];
            String bakingTech = doughData[2];
            double doughWeight = Double.valueOf(doughData[3]);
            Dough dough = new Dough(flourType, bakingTech, doughWeight);

            pizza.setDough(dough);
            while (true) {
                String[] toppingData = scan.readLine().split("\\s+");
                if (toppingData[0].equals("END")) {
                    break;
                }
                String toppingType = toppingData[1];
                double toppingWeight = Double.valueOf(toppingData[2]);
                Topping topping = new Topping(toppingType, toppingWeight);
                pizza.addTopping(topping);
            }
            System.out.printf("%s - %.2f", pizza.getName(), pizza.getCalories());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
