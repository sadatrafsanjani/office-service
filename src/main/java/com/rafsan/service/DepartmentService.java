package com.rafsan.service;

import com.rafsan.model.Department;
import java.util.List;

public interface DepartmentService {

    List<Department> getDepartments();
    Department getDepartment(long id);
    Department saveDepartment(Department department);
    void deleteDepartment(long id);
    Department updateDepartment(Department department);
}
