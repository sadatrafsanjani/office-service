package com.rafsan.controller;

import com.rafsan.model.Department;
import com.rafsan.model.Employee;
import com.rafsan.service.DepartmentService;
import com.rafsan.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {

    private DepartmentService departmentService;
    private EmployeeService employeeService;

    @Autowired
    public APIController(DepartmentService departmentService,
                         EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    /* DEPARTMENT */
    @GetMapping("/departments")
    public List<Department> getDepartments(){

        return departmentService.getDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartment(@PathVariable("id") long id){

        return departmentService.getDepartment(id);
    }

    @DeleteMapping("/departments/{id}")
    public void deleteDepartment(@PathVariable("id") long id){

        departmentService.deleteDepartment(id);
    }

    @RequestMapping(
            value = "/departments",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department){

        Department d = departmentService.saveDepartment(department);

        return new ResponseEntity<Department>(d, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/departments",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.PUT)
    public ResponseEntity<?> updateDepartment(@RequestBody Department department){

        Department d = departmentService.updateDepartment(department);

        return new ResponseEntity<Department>(d, HttpStatus.OK);
    }

    /* EMPLOYEE */
    @GetMapping("/employees")
    public List<Employee> getEmployees(){

        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable("id") long id ){

        return employeeService.getEmployee(id);
    }

    @RequestMapping(
            value = "/employees",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.PUT)
    public void updateEmployee(@RequestBody Employee employee){

        employeeService.updateEmployee(employee);
    }

    @RequestMapping(
            value = "/employees",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public Employee saveEmployee(@RequestBody Employee employee){

        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable("id") long id ){

        employeeService.deleteEmployee(id);
    }

    @GetMapping("/report")
    public void report(){

    }
}
