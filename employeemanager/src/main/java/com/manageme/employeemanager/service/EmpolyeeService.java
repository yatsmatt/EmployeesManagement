package com.manageme.employeemanager.service;

import com.manageme.employeemanager.exception.UserNotFoundException;
import com.manageme.employeemanager.model.Employee;
import com.manageme.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmpolyeeService {
    private final EmployeeRepo employeeRepo;

    //constractor
    @Autowired
    public  EmpolyeeService(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }
    public Employee addEmployee(Employee employee){
        employee.setEmployeeId(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }
    //get all employee
    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    public Employee findEmployeeById(Long id){
       return employeeRepo.findEmployeeById(id).orElseThrow(()->new UserNotFoundException("User whit the id "+" was not find "));
    }
    public void deleteEmployeeById(Long id) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
        if (optionalEmployee.isPresent()) {
            employeeRepo.deleteById(id);
        } else {
            // Handle the case where employee with given id is not found
            throw new RuntimeException("Employee not found with id: " + id);
        }
    }

}
