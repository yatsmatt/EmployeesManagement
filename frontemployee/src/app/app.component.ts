import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Employee } from './employee';
import { EmployeeService } from './employee.service';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import e, { response } from 'express';
import { NgForm } from '@angular/forms';
import { error } from 'console';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  employees?:Employee[];
  editedEmployee?:Employee ;
  deletedEmployee?:Employee;

  constructor(private employeeService: EmployeeService){}

  ngOnInit() {
    this.getEmployees();
  }
  //get all the employee
  public getEmployees(): void {
    this.employeeService.getEmployees().subscribe(
      (response: Employee[]) => {
        this.employees = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  // search for Employees
  public searchEmployees(index:string):void{
    const results : Employee[]=[]
    if(this.employees != null){
      for (const employee of this.employees) {
        if (employee.name.toLowerCase().indexOf(index.toLowerCase()) !== -1
        || employee.email.toLowerCase().indexOf(index.toLowerCase()) !== -1
        || employee.phone.toLowerCase().indexOf(index.toLowerCase()) !== -1
        || employee.jobTitle.toLowerCase().indexOf(index.toLowerCase()) !== -1) {
          results.push(employee);
        }
      }
      this.employees = results;
      if (results.length === 0 || !index) {
        this.getEmployees();
      }

    }
  }
  // add the employee front+back and set up temp 
  public addEmployee(){
    console.log("add")

  }
  // setting up temps will help whit the var to show in the front end
  public onAddEmployee(addEmployeeForm: NgForm){
    document.getElementById("closeAddEmployee")?.click()
    this.employeeService.addEmployees(addEmployeeForm.value).subscribe(
      (response:Employee)=>{
        console.log(response)
        this.getEmployees()
      },
      (error:HttpErrorResponse)=>{
        alert(error.message)
      }
    )
  }
  // edit the employee front+back and set up temp 
  public editEmployee(employee:Employee){
    //passing the value to the front end
    this.editedEmployee=employee;
  } 
  public onEditEmployee(editEmployeeForm: NgForm){
    document.getElementById("closeEditEmployee")?.click()
    this.employeeService.updateEmployees(editEmployeeForm.value).subscribe(
      (response:Employee)=>{
        console.log(response)
        this.getEmployees()
      },
      (error:HttpErrorResponse)=>{
        alert(error.message)
      }
    )
  }
    // delete the employee front+back and set up temp 
  public deleteEmployee(employee:Employee){
    console.log(employee.id)
    this.deletedEmployee=employee;
  } 
  public onDeleteEmployee(deleteEmployeeForm: NgForm){
    document.getElementById("closeDeleteEmployee")?.click()
    console.log(deleteEmployeeForm.value.id)
    this.employeeService.deleteEmployees(deleteEmployeeForm.value.id).subscribe(
      (response:Employee)=>{
        console.log(response)
        this.getEmployees()
      },
      (error:HttpErrorResponse)=>{
        alert(error.message)
      }
    )
  }
}
