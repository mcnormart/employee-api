package com.mcn.ct.employee.controller;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



import com.mcn.ct.employee.exception.InvalidEmployeeException;
import com.mcn.ct.employee.model.ErrorResponse;
import com.mcn.ct.employee.model.Employee;
import com.mcn.ct.employee.service.EmployeeService;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


//aka Delegate
@Controller


//call format
@RequestMapping("/employee")

public class EmployeeController {


    private EmployeeService employeeService;



    public void setEmployeeService(
    		EmployeeService employeeService) {


        this.employeeService = employeeService;
    }



   //GET http://localhost:8080/employees
    @RequestMapping(
            method = RequestMethod.GET
    )


   //GET /employee response
    @ResponseBody
    public Map<String, List<Employee>>
            getemployees() {



        Map<String, List<Employee>> response =
                new LinkedHashMap<String, List<Employee>>();


        //JSON construction
        response.put(
                "EmployeeList",
                employeeService.getAllEmployees()
        );



        return response;
    }


 
   //GET http://localhost:8080/employees/1
      @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET
    )
    @ResponseBody
    public ResponseEntity<Employee> getEmployee(
            @PathVariable("id") Integer id) {


        //return data if found, otherwise return exception
    	Employee employee =
        		employeeService.getEmployee(id);

        //response = OK
        return new ResponseEntity<Employee>(
        		employee,
                HttpStatus.OK
        );
    }


  
    //POST /employees
    @RequestMapping(
            method = RequestMethod.POST
    )
    
    
    @ResponseBody
    public ResponseEntity<Employee> addEmployee(
            @RequestBody Employee employee) {


    	Employee createdEmployee =
    			employeeService.addEmployee(
    					employee
                );


        //201 status = created
        return new ResponseEntity<Employee>(
                createdEmployee,
                HttpStatus.CREATED
        );
    }



    //DELETE /employee/2    
    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE
    )
    @ResponseBody
    public ResponseEntity<Void> deleteEmployee(
            @PathVariable("id") Integer id) {


 
        studentService.deleteEmployee(id);


        //error handling no content (204)
        return new ResponseEntity<Void>(
                HttpStatus.NO_CONTENT
        );
    }


   //error handling ; not found (404)
    @ExceptionHandler(
    		InvalidEmployeeException.class
    )
    @ResponseBody
    public ResponseEntity<ErrorResponse>
            handleNotFound(
            		InvalidEmployeeException exception) {


        
        ErrorResponse error =
                new ErrorResponse(
                        404,
                        exception.getMessage()
                );


        //error handlin g: not found (404)
        return new ResponseEntity<ErrorResponse>(
                error,
                HttpStatus.NOT_FOUND
        );
    }


    // error handling ; dupe (409)
    @ExceptionHandler(
    		InvalidEmployeeException.class
    )
    @ResponseBody
    public ResponseEntity<ErrorResponse>
            handleDuplicate(
            		InvalidEmployeeException exception) {


        ErrorResponse error =
                new ErrorResponse(
                        409,
                        exception.getMessage()
                );



        return new ResponseEntity<ErrorResponse>(
                error,
                HttpStatus.CONFLICT
        );
    }


   //error handling ; bad request (400)
    @ExceptionHandler(
    		InvalidEmployeeException.class
    )
    @ResponseBody
    public ResponseEntity<ErrorResponse>
            handleInvalidStudent(
            		InvalidEmployeeException exception) {


        ErrorResponse error =
                new ErrorResponse(
                        400,
                        exception.getMessage()
                );


        //error handling ; bad request (400)
        return new ResponseEntity<ErrorResponse>(
                error,
                HttpStatus.BAD_REQUEST
        );
    }


}
