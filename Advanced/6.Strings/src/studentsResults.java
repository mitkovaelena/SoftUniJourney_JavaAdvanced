import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.TreeMap;
import java.util.TreeSet;

public class studentsResults {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if(n == 0) return;
        TreeMap<String, Double[]> studentsGrades = new TreeMap<>();

        System.out.println("Name      |   JAdv|JavaOOP| AdvOOP|Average|");

        for (int i = 0; i < n; i++) {
            String[]  line = reader.readLine().split("[,-]");
            String name = line[0].trim();
            Double jAdv = Double.parseDouble(line[1].trim());
            Double jOOP = Double.parseDouble(line[2].trim());
            Double advOOP = Double.parseDouble(line[3].trim());
            Double average = (jAdv+jOOP+advOOP)/3;

            studentsGrades.put(name, new Double[] {jAdv,jOOP,advOOP,average });
        }

        for(String s: studentsGrades.keySet()){
            System.out.println(String.format("%-10s|%7.2f|%7.2f|%7.2f|%7.4f|", s,studentsGrades.get(s)[0],studentsGrades.get(s)[1],studentsGrades.get(s)[2],studentsGrades.get(s)[3]).replaceAll("\\.", ","));

        }
    }
}
