package com.impact.repository;

import com.impact.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Optional<Employee> findByEmailAddress(String emailAddress);
    void get(Long aClass);
}