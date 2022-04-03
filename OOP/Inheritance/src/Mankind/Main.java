package Mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.instrument.IllegalClassFormatException;

public class Main {
    public static void main(String[] args) throws IllegalClassFormatException, IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String[] studentString = reader.readLine().split("\\s+");
            String[] workerString = reader.readLine().split("\\s+");

            Student student = new Student(studentString[0],studentString[1],studentString[2]);

            Worker worker = new Worker(workerString[0],workerString[1],Double.parseDouble(workerString[2]), Double.parseDouble(workerString[3]));

            System.out.println(student.toString());
            System.out.println();
            System.out.println(worker.toString());

        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
    }
}
