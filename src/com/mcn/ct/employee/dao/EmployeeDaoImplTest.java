package com.mcn.ct.employee.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.mcn.ct.employee.model.Employee;

import com.mcn.ct.employee.dao.EmployeeDao;


import static org.junit.Assert.*;


public class EmployeeDaoImplTest {



	
	    private EmployeeDao employeeDao;



	    @Before
	    public void setUp() {


	
	    	EmployeeDaoImpl.reset();


	        
	    	employeeDao =
	                new EmployeeDaoImpl();
	    }



	    @Test
	    public void testFindAll() {


	        List<Employee> employees =
	        		employeeDao.findAll();



	        assertEquals(
	                2,
	                employees.size()
	        );


	        assertEquals(
	                "Prem",
	                employees.get(0).getFirstName()
	        );

	    }



	    @Test
	    public void testFindById() {


	    	Employee employee =
	    			employeeDao.findById(1);


	        assertNotNull(employee);


	        assertEquals(
	                Integer.valueOf(1),
	                employee.getId()
	        );


	        assertEquals(
	                "Vikash",
	                employee.getFirstName()
	        );

	    }


	
	    @Test
	    public void testFindByIdNotFound() {


	    	Employee employee =
	    			employeeDao.findById(999);


	        assertNull(employee);

	    }


	
	    @Test
	    public void testSave() {


	    	Employee vikash =
	                new Employee(
	                        3,
	                        "Vikash",
	                        "Kumar",
	                        "asdj@yahoo.com"
	                );


	    	employeeDao.save(vikash);


	    	Employee result =
	        		employeeDao.findById(3);


	        assertNotNull(result);


	        assertEquals(
	                "Vikash",
	                result.getFirstName()
	        );

	    }


	
	    @Test
	    public void testDelete() {


	        boolean deleted =
	        		employeeDao.delete(2);


	        assertTrue(deleted);


	        assertNull(
	        		employeeDao.findById(2)
	        );

	    }

	}
