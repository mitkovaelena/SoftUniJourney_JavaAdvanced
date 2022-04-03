package Mankind;

public class Student extends Human {
    private String facultyNumber;

    public Student(String firstName, String lasttName, String facultyNumber) {
        super(firstName, lasttName);
        this.setFacultyNumber(facultyNumber);
    }

    private void setFacultyNumber(String facultyNumber) {
        if (facultyNumber.length() < 5 || facultyNumber.length() > 10) {
            throw new IllegalArgumentException("Invalid faculty number!");
        }
        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString() {
        return "First Name: " + super.getFirstName() +
                "\nLast Name: " + super.getLastName() +
                "\nFaculty number: " +this.facultyNumber;
    }
}
