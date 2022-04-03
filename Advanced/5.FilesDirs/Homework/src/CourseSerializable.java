import java.io.*;

public class CourseSerializable {
    public static void main(String[] args) {
        final String objPath = ".\\course.ser";

        Course course = new Course();
        course.name = "Java Advanced";
        course.studentsNum = 233;

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objPath))){
            oos.writeObject(course);
        } catch (IOException e){
            e.printStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(objPath))){
            Course courseLoaded = (Course) ois.readObject();
            System.out.println("Course name: " + courseLoaded.name);
            System.out.println("Number of students attending the course: " + courseLoaded.studentsNum);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
