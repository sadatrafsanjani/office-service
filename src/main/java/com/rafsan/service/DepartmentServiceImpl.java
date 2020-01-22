package com.rafsan.service;

import com.rafsan.model.Department;
import com.rafsan.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> getDepartments(){

        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartment(long id){

        return departmentRepository.getOne(id);
    }

    @Override
    public Department saveDepartment(Department department){

        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(long id){

        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Department department){

        departmentRepository.update(
                department.getDepartmentCode(),
                department.getName(),
                department.isActive(),
                department.getId());

        return departmentRepository.findById(department.getId()).orElse(null);
    }
}
