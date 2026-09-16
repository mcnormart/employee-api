package com.mcn.ct.employee.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.mcn.ct.employee.dao.EmployeeDaoImpl;

import com.mcn.ct.employee.exception.InvalidEmployeeException;
import com.mcn.ct.employee.exception.EmployeeNotFoundException;

import com.mcn.ct.employee.model.Employee;


import static org.junit.Assert.*;


public class EmployeeServiceImplTest {


    private EmployeeService employeeService;


    @Before
    public void setUp() {


    	EmployeeDaoImpl.reset();
        

   
    	EmployeeDaoImpl employeeDao =
                new EmployeeDaoImpl();


    
    	EmployeeServiceImpl service =
                new EmployeeServiceImpl();


    
        service.setEmployeeDao(
        		employeeDao
        );


      
        employeeService = service;

    }


    @Test
    public void testGetAllEmployee() {
    	

        List<Employee> employee = 
       		employeeService.getAllEmployees();


        assertEquals(
                2,
                employee.size()
        );

    }


    @Test
    public void testGetEmployee() {


    	Employee employee =
    			employeeService.getEmployee(1);
        assertEquals(
                "Prem",
                employee.getFirstName()
        );


        assertEquals(
                "Tiwari",
                employee.getLastName()
        );

    }



    
    @Test(
        expected =
        		EmployeeNotFoundException.class
    )
    public void testGetEmployeeNotFound() {


       
         // This should throw the exception.
       
        employeeService.getEmployee(999);

    }
  

    
    @Test
    public void testAddEmployee() {


    	Employee vikash =
                new Employee(
                        3,
                        "Vikash",
                        "Kumar",
                        "asdj@gmail.com"
                );


        Employee result =
        		employeeService.addEmployee(
                        vikash
                );


        assertEquals(
                Integer.valueOf(3),
                result.getId()
        );


        assertEquals(
                "Mary",
                result.getFirstName()
        );

    }
    

    @Test(
        expected =
            InvalidEmployeeException.class
    )
    public void testDuplicateEmployee() {


        Employee duplicate =
                new Employee(
                        1,
                        "Prem",
                        "Tiwari",
                        "premt@yahoo.com"
                );


        employeeService.addEmployee(
                duplicate
        );

    }


    @Test
    public void testDeleteEmployee() {

        employeeService.deleteEmployee(2);
    	
        List<Employee> employee = employeeService.getAllEmployees();
        assertEquals(
                1,
                employee.size()
        );

    }


    @Test(
        expected =
        		EmployeeNotFoundException.class
    )
    public void testDeleteEmployeeNotFound() {


    	employeeService.deleteEmployee(999);

    }
  
 }