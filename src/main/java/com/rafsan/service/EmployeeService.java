package com.rafsan.service;

import com.rafsan.model.Employee;
import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();
    Employee getEmployee(long id);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(long id);
    void updateEmployee(Employee employee);
}
