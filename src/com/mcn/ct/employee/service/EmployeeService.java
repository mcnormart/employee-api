package com.mcn.ct.employee.service;

import java.util.List;

import com.mcn.ct.employee.model.Employee;

//business rules
public interface EmployeeService {

    //get all Employee
    List<Employee> getAllEmployees();


    //retrieve 1
    Employee getEmployee(Integer id);


    //create 1
    Employee addEmployee(Employee employee);


    //remove 1
    void deleteEmployee(Integer id);
	
}

