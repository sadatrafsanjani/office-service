package com.rafsan.service;

import com.rafsan.model.Employee;
import com.rafsan.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEmployees(){

        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(long id){

        return employeeRepository.getOne(id);
    }

    @Override
    public Employee saveEmployee(Employee employee){

        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(long id){

        employeeRepository.deleteById(id);
    }

    @Override
    public void updateEmployee(Employee employee){

        employeeRepository.update(
                employee.getDepartment(),
                employee.getName(),
                employee.getPhoto(),
                employee.getJoiningDate(),
                employee.getDateOfBirth(),
                employee.getDesignation(),
                employee.getBasicSalary(),
                employee.getGender(),
                employee.getId()
                );
    }
}
