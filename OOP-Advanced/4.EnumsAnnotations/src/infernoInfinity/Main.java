package infernoInfinity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Weapon> weapons = new LinkedHashMap<>();
        Class<Weapon> weaponClass = Weapon.class;
        Anno annotation = weaponClass.getAnnotation(Anno.class);

        while (true) {
            String[] input = reader.readLine().split(";");
            if (input[0].equals("END")) {
                break;
            }

            switch (input[0]) {
                case "Create":
                    Weapon w = new Weapon(input[1], input[2]);
                    weapons.put(input[2], w);
                    break;
                case "Add":
                    weapons.get(input[1]).insertGem(Integer.parseInt(input[2]), input[3]);
                    break;
                case "Remove":
                    weapons.get(input[1]).removeGem(Integer.parseInt(input[2]));
                    break;
                case "Print":
                    System.out.println(weapons.get(input[1]));
                    break;
                case "Compare":
                    if(weapons.get(input[1]).compareTo(weapons.get(input[2])) >= 0){
                        System.out.println(weapons.get(input[1]) + " " + weapons.get(input[1]).printLvl());
                    } else {
                        System.out.println(weapons.get(input[2]) + " " + weapons.get(input[2]).printLvl());
                    }
                    break;
                case "Author":
                    System.out.printf("Author: %s%n", annotation.author());
                    break;
                case "Revision":
                    System.out.printf("Revision: %s%n", annotation.revision());
                    break;
                case "Description":
                    System.out.printf("Class description: %s%n", annotation.description());
                    break;
                case "Reviewers":
                    System.out.printf("Reviewers: %s%n", String.join(", ", annotation.reviewers()));
                    break;
                default:
                    break;
            }
        }
    }
}