package com.manageme.employeemanager;

import com.manageme.employeemanager.model.Employee;
import com.manageme.employeemanager.service.EmpolyeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Logger;

import java.util.List;

// repo is configuration of all the routes needed whit every method and the values needed for the method

@RestController
@RequestMapping("/employee")
public class EmployeeResouce {
    // keep a EmpolyeeService obj so we can do manipulation on it
    private final EmpolyeeService empolyeeService;

    public EmployeeResouce(EmpolyeeService empolyeeService) {
        this.empolyeeService = empolyeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employees = empolyeeService.findAllEmployee();
        //        working
//        System.out.println(employees);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
//        working
        Employee newEmployee = empolyeeService.addEmployee(employee);
//        System.out.println("New employee added: " + newEmployee);
        return new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        System.out.println("New employee updated: " + employee);
        Employee updateEmployee = empolyeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee,HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getmEployeeById(@PathVariable("id") Long id){
        Employee employee = empolyeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable Long id) {
        try {
            empolyeeService.deleteEmployeeById(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Employee not found with ID: " + id);
        }
    }

}
