package Exer3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String command = reader.readLine();
            if ("Tournament".equals(command)) {
                break;
            }
            String[] line = command.split("\\s+");
            Pokemon pokemon = new Pokemon(line[1], line[2], Integer.valueOf(line[3]));
            Trainer trainer = new Trainer(line[0]);

            ArrayList<Pokemon> pokemons = new ArrayList<>();
            if(trainers.containsKey(line[0])){
                pokemons = trainers.get(line[0]).getPokemons();
            }
            pokemons.add(pokemon);
            trainer.setPokemons(pokemons);
            trainers.put(line[0],trainer);
        }
        while (true) {
            String command = reader.readLine();
            if ("End".equals(command)) {
                break;
            }
            String line = command;

            for(Trainer t : trainers.values()){
                trainers = battle(trainers, t, line);
            }
         }

        trainers.entrySet().stream()
                .sorted((p1,p2) -> Integer.compare(p2.getValue().getBadges(), p1.getValue().getBadges()))
                .forEachOrdered(x -> System.out.println(x.getValue().getName() + " " + x.getValue().getBadges() + " " + x.getValue().getPokemons().size()));

    }

    private static LinkedHashMap<String, Trainer> battle(LinkedHashMap<String, Trainer> trainers,Trainer t, String element) {
            for (Pokemon p : t.getPokemons()) {
                if (p.getElement().equals(element)) {
                    t.setBadges(t.getBadges() + 1);
                     trainers.put(t.getName(),t);
                    return trainers;
                }
            }
            t.getPokemons().stream().forEach(x-> x.setHealth(x.getHealth()-10));
            t.getPokemons().removeIf(x-> x.getHealth()<=0);
            trainers.put(t.getName(),t);
            return trainers;
    }
}
