package p03_employee_info;

public class ConsoleClient {
   private InfoProvider employeeInfo = new EmployeeInfoProvider();
   private Formatter formatter = new ConsoleFormatter();

    public ConsoleClient(InfoProvider employeeInfo, Formatter formatter) {
        this.employeeInfo = employeeInfo;
        this.formatter = formatter;
    }

    public String getResult(){
        return formatter.format(employeeInfo.getEmployeesBy((e1,e2) -> e1.getName().compareTo(e2.getName())));
    }
}
