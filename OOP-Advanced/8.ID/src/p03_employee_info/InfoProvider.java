package p03_employee_info;

import java.util.Comparator;
import java.util.List;

public interface InfoProvider {
    List<Employee> getEmployeesBy(Comparator<Employee> comparator);
}
