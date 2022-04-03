import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, Double> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String[] grades = scanner.nextLine().split(" ");
            double grade = 0;
            for(String g : grades){
                grade+=Double.parseDouble(g);
            }
            grade /= grades.length;
            students.put(name, grade);
        }

        for (String key : students.keySet()) {
            System.out.println(key + " is graduated with " + students.get(key));
        }
    }
}
