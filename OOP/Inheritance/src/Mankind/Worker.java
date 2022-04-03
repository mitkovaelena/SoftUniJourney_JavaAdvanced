package Mankind;

public class Worker extends Human {
    private Double weekSalary;
    private Double workHoursPerDay;

    public Worker(String firstName, String lastName, Double weekSalary, Double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    private Double calculateSalaryPerHour(){
        return (this.weekSalary/7)/this.workHoursPerDay;
    }

    @Override
    protected void setLastName(String lastName) {
        if (lastName.length() <= 3) {
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    public void setWeekSalary(Double weekSalary) {
        if (weekSalary < 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    public void setWorkHoursPerDay(Double workHoursPerDay) {
        if (workHoursPerDay < 1  && workHoursPerDay > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    @Override
    public String toString() {
        return "First Name: " + super.getFirstName() +
                "\nLast Name: " + super.getLastName() +
                String.format("\nWeek Salary: %.2f", this.weekSalary) +
                String.format("\nHours per day: %.2f", this.workHoursPerDay) +
                String.format("\nSalary per hour: %.2f", this.calculateSalaryPerHour());
    }
}
