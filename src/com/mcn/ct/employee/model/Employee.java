package com.mcn.ct.employee.model;



//my Employee Java beans
public class Employee {
		
    private Integer id;    
    private String firstName;
    private String lastName;
    private String email; 
    
    //will be used by Jackson
    public Employee() {}
    
    public Employee(
            Integer id,
            String firstName,
            String lastName,
            String email) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    

     /*
      * SETTERS
      */
     public void setId(Integer id) {

         this.id = id;
     }
     
     public void setFirstName(String fname) {

         this.firstName = fname;
     }
     

     public void setLastName(String lname) {

         this.lastName = lname;
     }
     
  
     public void setEmail(String email) {

         this.email = email;
     } 
         
     /*
      * Getters
      */
     
      public Integer getId() {

         return id;
     }
     
      public String getFirstName() {

          return firstName;
      }
      
      public String getLastName() {

          return lastName;
      }
      
     
      public String getEmail() {

          return email;
      }
      
     
}
