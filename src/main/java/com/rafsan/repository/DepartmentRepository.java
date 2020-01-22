package com.rafsan.repository;

import com.rafsan.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Modifying
    @Query("UPDATE Department D SET " +
            "D.departmentCode = ?1, " +
            "D.name = ?2, " +
            "D.active = ?3 " +
            "WHERE D.id = ?4")
    void update(String departmentCode,
                String name,
                boolean active,
                long id);
}
