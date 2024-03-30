package com.manageme.employeemanager.service;

import com.manageme.employeemanager.model.Employee;
import com.manageme.employeemanager.repo.EmpoyeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmpolyeeService {
    private final EmpoyeeRepo empoyeeRepo;

    //constractor
    @Autowired
    public  EmpolyeeService(EmpoyeeRepo empoyeeRepo){
        this.empoyeeRepo=empoyeeRepo;
    }
    public Employee addEmployee(Employee employee){
        employee.setEmployeeId(UUID.randomUUID().toString());
        return empoyeeRepo.save(employee);
    }
}
