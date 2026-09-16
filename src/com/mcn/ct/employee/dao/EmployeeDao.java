package com.mcn.ct.employee.dao;


import java.util.List;

import com.mcn.ct.employee.model.Employee;



public interface EmployeeDao {


   
    //Return all Employees.
    List<Employee> findAll();


    //Find one employee by ID.    
    Employee findById(Integer id);


    
     // Store an employee.
     void save(Employee employee);


    
    //determine whether an ID exists.
    boolean exists(Integer id);


    //Delete the employee with this ID.
     boolean delete(Integer id);

}

