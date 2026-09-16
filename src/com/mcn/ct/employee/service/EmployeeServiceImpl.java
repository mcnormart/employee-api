package com.mcn.ct.employee.service;
import java.util.List;

import com.mcn.ct.employee.dao.EmployeeDao;
import com.mcn.ct.employee.model.Employee;
import com.mcn.ct.employee.exception.InvalidEmployeeException;

public class EmployeeServiceImpl 
         implements EmployeeService {


    private EmployeeDao employeeDao;
    

    public void setEmployeeDao(
            EmployeeDao employeeDao) {


        this.employeeDao = employeeDao;
    }
    
    
 
    @Override
    public List<Employee> getAllEmployees() {

    	List<Employee>  employee =
        		employeeDao.findAll();
    	
    	//if datastorage is empty
        if (employee == null) {


            throw new InvalidEmployeeException(
                    "Employee record is null."
            );
        } 	
        return employeeDao.findAll();
    }
    
    

    @Override
    public Employee getEmployee(Integer id) {


        //iff null id
        if (id == null) {


            throw new InvalidEmployeeException(
                    "Employee id cannot be null."
            );
        }


        Employee employee =
        		employeeDao.findById(id);


        //ifid not found
        if (employee == null) {


            throw new InvalidEmployeeException(
                    "Employee " + id
                    + " was not found."
            );
        }


        return employee;
    } 
    
   
    @Override
    public Employee addEmployee(
    		Employee employee) {


        //empty parameter
        if (employee == null) {


            throw new InvalidEmployeeException(
                    "Employee cannot be null."
            );
        }


        //if id is null
        if (employee.getId() == null) {


            throw new InvalidEmployeeException(
                    "Employee id is required."
            );
        }    

        //if first name is null
        if (employee.getFirstName() == null
                || employee.getFirstName().trim().length() == 0) {


            throw new InvalidEmployeeException(
                    "Employee first name is required."
            );
        }


        
         //if last name is null         
        if (employee.getLastName() == null
                || employee.getLastName().trim().length() == 0) {


            throw new InvalidEmployeeException(
                    "employee last name is required."
            );
        }
        //if dupe
        if (employeeDao.exists(
        		employee.getId())) {


            throw new InvalidEmployeeException(
                    "Employee id "
                    + employee.getId()
                    + " already exists."
            );
        }


        
        employeeDao.save(employee);


        
        return employee;     
    }
    
  
    @Override
    public void deleteEmployee(Integer id) {


        //if null id
        if (id == null) {


            throw new InvalidEmployeeException(
                    "Employee id cannot be null."
            );
        }


        
        boolean deleted =
        		employeeDao.delete(id);


        //if data does not exist
        if (!deleted) {  

            throw new InvalidEmployeeException(
                    "Employee " + id
                    + " was not found."
            );
        }

    }
}
