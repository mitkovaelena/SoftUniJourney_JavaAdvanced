package p03_employee_info;

public class Main {

    public static void main(String[] args) {
        InfoProvider employeeInfo = new EmployeeInfoProvider();
        Formatter formatter = new ConsoleFormatter();

        ConsoleClient consoleClient = new ConsoleClient( new EmployeeInfoProvider(), new ConsoleFormatter());

        System.out.println(consoleClient.getResult());
    }
}
