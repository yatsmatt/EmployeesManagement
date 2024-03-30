package com.manageme.employeemanager.repo;

import com.manageme.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpoyeeRepo  extends JpaRepository<Employee,Long> {


}
