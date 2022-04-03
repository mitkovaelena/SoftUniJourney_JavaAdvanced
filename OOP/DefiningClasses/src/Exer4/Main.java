package Exer4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        LinkedHashMap<String, Person> people = new LinkedHashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String command = reader.readLine();
            if ("End".equals(command)) {
                break;
            }
            String[] line = command.split("\\s+");
            Person person = new Person(line[0]);
            if(people.containsKey(line[0])) person = people.get(line[0]);

            switch (line[1]){
                case "company":
                    command = command.replace(line[line.length-1] , String.format("%.2f", Double.parseDouble(line[line.length-1])));
                    person.setCompany(command.substring(command.indexOf(line[2])));
                    break;
                case "car":
                    person.setCar(command.substring(command.indexOf(line[2])));
                    break;
                case "pokemon":
                    ArrayList<String> temp = person.getPokemons();
                    temp.add(command.substring(command.indexOf(line[2])));
                    person.setPokemons(temp);
                    break;
                case "parents":
                    ArrayList<String> temp1 = person.getParents();
                    temp1.add(command.substring(command.indexOf(line[2])));
                    person.setParents(temp1);
                    break;
                case "children":
                    ArrayList<String> temp2 = person.getChildren();
                    temp2.add(command.substring(command.indexOf(line[2])));
                    person.setChildren(temp2);
                    break;
            }
            people.put(line[0], person);
        }

        String reportForPerson = reader.readLine();
        Person reportedPerson = people.get(reportForPerson);
        String company = reportedPerson.getCompany().equals("")?"":(reportedPerson.getCompany()+"\n");
        String car = reportedPerson.getCar().equals("")?"":(reportedPerson.getCar()+"\n");
        String pokemon = reportedPerson.getPokemons().isEmpty()?"":(reportedPerson.getPokemons().toString().replace("[", "").replace("]", "").replaceAll(", ", "\n")+"\n");
        String parents = reportedPerson.getParents().isEmpty()?"":(reportedPerson.getParents().toString().replace("[", "").replace("]", "").replaceAll(", ", "\n")+"\n");
        String children = reportedPerson.getChildren().isEmpty()?"":(reportedPerson.getChildren().toString().replace("[", "").replace("]", "").replaceAll(", ", "\n")+"\n");
        System.out.println(reportedPerson.getName() +
                "\nCompany:\n" + company +
                "Car:\n" + car +
                "Pokemon:\n" + pokemon +
                "Parents:\n" + parents +
                "Children:\n" + children
);
    }
}
