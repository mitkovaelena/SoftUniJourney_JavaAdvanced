import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] inputStr = scanner.nextLine().split(" ");
        ArrayDeque<String> plants = new ArrayDeque<>();
        ArrayDeque<String> help = new ArrayDeque<>();
        int daysCount = 0;
        for (int i = 0; i < n; i++) {
            plants.push(inputStr[i]);
        }

        boolean hasChanged = false;
        while(true){
            if(plants.size()>1){
            String temp =  plants.pop();
            String temp2 = plants.peek();
            if(Integer.parseInt(temp2)>=Integer.parseInt(temp)){
                help.push(temp);
            }
            else hasChanged = true;
            }
            else {
                if(!hasChanged){
                    System.out.println(daysCount);
                    return;
                }
                daysCount++;
                while(!help.isEmpty()) {
                plants.push(help.pop());
                }
                hasChanged = false;
            }
        }
    }
}
