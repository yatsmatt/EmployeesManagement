import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';
import e from 'express';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
    // URL of  API server
  private apiServerUrl=" ";

  // Adding the HttpClient for  HTTP requests
  constructor(private http:HttpClient){}


  // Method to fetch all\add\update\delete on data 
  public getEmployees(): Observable<Employee[]> {    
    return this.http.get<Employee[]>(`${this.apiServerUrl}/employee/all`);
  }
 
  public addEmployees(employee:Employee): Observable<Employee> {    
    return this.http.post<Employee>(`${this.apiServerUrl}/employee/add`,employee);
  }
  public updateEmployees(employee:Employee): Observable<Employee> {    
    return this.http.put<Employee>(`${this.apiServerUrl}/employee/update`,employee);
  }
  public deleteEmployees(id:number): Observable<Employee> {    
    return this.http.delete<Employee>(`${this.apiServerUrl}/employee/delete/${id}`);

  }
}
