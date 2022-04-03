import java.util.*;
import java.util.stream.Collectors;

public class populationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String,LinkedHashMap<String, Long>> countries = new LinkedHashMap<>();
        LinkedHashMap<String, Long> countryPopulation  = new LinkedHashMap<>();

        while(true){
            String inputline = scanner.nextLine();
            if(inputline.equals("report")) break;
            String[] line = inputline.split("\\|");
            String city = line[0];
            String country = line[1];
            Long population = Long.parseLong(line[2]);
            if(countries.containsKey(country)) {
                    countries.get(country).put(city, population);
                    countryPopulation.put(country, countryPopulation.get(country)+population);
            }
            else {
                LinkedHashMap<String, Long> temp = new LinkedHashMap<>();
                temp.put(city, population);
                countries.put(country,temp);
                countryPopulation.put(country,population);
            }
        }

        Map<String, Long> sortedCountryPopulation = new LinkedHashMap<String, Long>();
        countryPopulation.entrySet().stream()
                .sorted(Map.Entry.<String, Long> comparingByValue().reversed())
                .forEachOrdered(x -> sortedCountryPopulation.put(x.getKey(), x.getValue()));

        String output = new String();
        for(String key : sortedCountryPopulation.keySet()){
            output += key + " (total population: " + sortedCountryPopulation.get(key) + ")\n";
            
            Map<String, Long> sortedCities = new LinkedHashMap<String, Long>();
            countries.get(key).entrySet().stream()
                    .sorted(Map.Entry.<String, Long> comparingByValue().reversed())
                    .forEachOrdered(x -> sortedCities.put(x.getKey(), x.getValue()));
            
            for(String city : sortedCities.keySet()) {
                output += "=>"+ city + ": " + countries.get(key).get(city) + "\n";
            }
        }
        System.out.println(output);
    }
}
