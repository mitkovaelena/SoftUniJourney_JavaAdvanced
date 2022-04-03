package p03_employee_info;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeInfoProvider implements InfoProvider {

    private Database database;

    public EmployeeInfoProvider() {
        this.database = new EmployeeDatabase();
    }

    @Override
    public List<Employee> getEmployeesBy(Comparator<Employee> comparator) {
        return this.database.readEmployees().stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
