package com.mcn.ct.employee.dao;

import java.util.ArrayList;
import java.util.List;

import com.mcn.ct.employee.model.Employee;


public class EmployeeDaoImpl
     implements EmployeeDao {

     

	   
	    private static final List<Employee> employees =
	            new ArrayList<Employee>();



	    static {


	    	employees.add(

	                new Employee(
	                        1,
	                        "Prem",
	                        "Tiwari",
	                        "prem@gmail.com"
	                )
	        );


	    	employees.add(

	                new Employee(
	                        2,
	                        "Vikash",
	                        "Kumar",
	                        "abc@yahoo.com"
	                )
	        );
	    	
	    	employees.add(

	                new Employee(
	                        3,
	                        "Vikash",
	                        "Kumar",
	                        "defg@yahoo.com"
	                )
	        );	

	    }


	    //findAll implementation
	    @Override
	    public List<Employee> findAll() {



	        return new ArrayList<Employee>(
	        		employees
	        );
	    }


	    //findbyId implementation
	    @Override
	    public Employee findById(Integer id) {

	    	for (Employee employee : employees) {

	            if (employee.getId().equals(id)) {

	                return employee;
	            }
	        }


	       //record not found
	        return null;
	    }


	    //add implementaion
	    @Override
	    public void save(Employee employee) {

	    	employees.add(employee);
	    }


        
	    //negative scenario check
	    @Override
	    public boolean exists(Integer id) {


	        for (Employee employee : employees) {


	            if (employee.getId().equals(id)) {


	                return true;
	            }
	        }


	        return false;
	    }


	    
	    //delete implementation
	    @Override
	    public boolean delete(Integer id) {


       
	    	Employee employeeToDelete = null;

            //find the record
	        for (Employee employee : employees) {

	            if (employee.getId().equals(id)) {


	            	employeeToDelete = employee;


	                break;
	            }
	        }
	      
	        
	        //if found
	        if (employeeToDelete != null) {

	        	employees.remove(employeeToDelete);
                return true;
	        }


	        //if not found
	        return false;        
	}
	    
	    
	    //for clean-up..just in case
	    public static void reset() {


	    	employees.clear();


	    	employees.add(

	                new Employee(
	                        1,
	                        "Prem",
	                        "Tiwari",
	                        "prem@gmail.com"
	                )
	        );


	    	employees.add(

	                new Employee(
	                        2,
	                        "Vikash",
	                        "Kumar",
	                        "abc@yahoo.com"
	                )
	        );
	    	
	    	employees.add(

	                new Employee(
	                        3,
	                        "Vikash",
	                        "Kumar",
	                        "defg@yahoo.com"
	                )
	        );	    	

	    }
}
