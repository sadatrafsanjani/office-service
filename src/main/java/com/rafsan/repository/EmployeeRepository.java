package com.rafsan.repository;

import com.rafsan.model.Department;
import com.rafsan.model.Employee;
import com.rafsan.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Modifying
    @Query("UPDATE Employee E SET " +
            "E.department = ?1, " +
            "E.name = ?2, " +
            "E.photo = ?3, " +
            "E.joiningDate = ?4, " +
            "E.dateOfBirth = ?5, " +
            "E.designation = ?6, " +
            "E.basicSalary = ?7, " +
            "E.gender = ?8 " +
            "WHERE E.id = ?9")
    void update(Department department,
                String name,
                String photo,
                String joiningDate,
                String dateOfBirth,
                double basicSalary,
                Gender gender,
                long id);
}
