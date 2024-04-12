package com.manageme.employeemanager.repo;

import com.manageme.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// jpa repo let us use some basic func as find and find all to help us
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

//    void deleteEmployeeById(Long id);
    // over write a func

    Optional<Employee> findEmployeeById(Long id);


}
