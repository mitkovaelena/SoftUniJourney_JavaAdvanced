import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Path studentsDataPath = Paths.get(".\\StudentData.txt");
        List<String> data = new ArrayList<>();

        try {
            data = Files.readAllLines(studentsDataPath);
        } catch (IOException e){
            e.printStackTrace();
        }
        List<Student> students = new ArrayList<>();

        for (int i = 1; i < data.size(); i++) {
            String[] tokens = data.get(i).split("\\s+");
             Student student = new Student(tokens[0],tokens[1],tokens[2],tokens[3],
                     Integer.valueOf(tokens[4]), Integer.valueOf(tokens[5]), tokens[10]);

            for (int j = 6; j < 10; j++) {
                student.getGrades().add(Integer.valueOf(tokens[j]));
            }
            students.add(student);
        }

//        students.stream().filter( s -> s.getGroup() == 2)
//                .sorted((s1,s2) -> s1.getFirstName().compareTo(s2.getFirstName()))
//                .forEach( y -> System.out.println(y.getFirstName() + " " + y.getLastName()));

//        students.stream().filter( s -> s.getFirstName().compareTo(s.getLastName()) < 0)
//                .forEach( y -> System.out.println(y.getFirstName() + " " + y.getLastName()));

//        students.stream().filter( s -> s.getAge() >= 18 && s.getAge() <= 24)
//                .forEach( y -> System.out.println(y.getFirstName() + " " + y.getLastName() + " " + y.getAge()));

//        students.stream()
//                .sorted((s1,s2) -> s2.getFirstName().compareTo(s1.getFirstName()))
//                .sorted((s1,s2) -> s1.getLastName().compareTo(s2.getLastName()))
//                .forEach( y -> System.out.println(y.getFirstName() + " " + y.getLastName()));

//        students.stream().filter( s -> s.getEmail().endsWith("@gmail.com"))
//                .forEach( y -> System.out.println(y.getFirstName() + " " + y.getLastName() + " " + y.getEmail()));

//        students.stream().filter( s -> s.getPhone().startsWith("02") || s.getPhone().startsWith("+3592"))
//                .forEach( y -> System.out.println(y.getFirstName() + " " + y.getLastName() + " " + y.getPhone()));

//        students.stream().filter( s -> s.getGrades().contains(6))
//                .forEach( y -> System.out.println(y.getFirstName() + " " + y.getLastName() + " " +
//                        y.getGrades().stream()
//                            .sorted((a,b) -> b.compareTo(a))
//                            .map(x -> String.valueOf(x))
//                        .reduce((g1,g2) -> g1 + " " + g2).toString().replaceAll("[\\[\\]]", "").replaceAll("Optional", "")));

//        students.stream().filter( s -> s.getGrades().stream().mapToInt(Integer::valueOf).sorted().skip(1).limit(1).sum() <= 3)
//                .sorted((e1,e2) -> Integer.compare(
//                        e1.getGrades().stream().mapToInt(Integer::valueOf).sum(),
//                        e2.getGrades().stream().mapToInt(Integer::valueOf).sum())
//                )
//                .forEach( y -> System.out.println(y.getFirstName() + " " + y.getLastName() + " " +
//                        y.getGrades().stream()
//                                .sorted((a,b) -> a.compareTo(b))
//                                .map(x -> String.valueOf(x))
//                                .reduce((g1,g2) -> g1 + " " + g2).toString().replaceAll("[\\[\\]]", "").replaceAll("Optional", "")));

        Map<Integer, List<Student>> stByYear = students.stream().collect(Collectors.groupingBy(
                s -> Integer.valueOf(
                        s.getFacultyNumber().substring(s.getFacultyNumber().length()-2)
                )
        ));

        Map<Integer, List<Student>> sortedStByYear = new TreeMap<>();
        stByYear.entrySet().stream()
                .forEachOrdered(x -> sortedStByYear.put(x.getKey(), x.getValue()));

        for(Integer key : sortedStByYear.keySet()){
            System.out.println("20" + key + ":");
            for(String s : stByYear.get(key).stream().sorted((a,b) -> a.getFullName()
                    .compareTo(b.getFullName())).map(Student::getFullName).collect(Collectors.toList())) {
                System.out.println("-- " + s);

            }
        }


    }
}
