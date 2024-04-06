package com.employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.BO.Employee;
import com.employee.Repositary.EmployeeRepository;
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	Employee employee = new Employee();
	@GetMapping(path="/")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		
		List<Employee> employeeList=employeeRepository.findAll();
		if(null==employeeList) {
			return new ResponseEntity<>(employeeList,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(employeeList,HttpStatus.OK);
	}
	 @GetMapping(path="/{id}")
   public ResponseEntity<Employee> getEmployee(@PathVariable long id) {
		 try {
			 employee =employeeRepository.findById(id).get();
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	   if(null==employee) {
		   return new ResponseEntity<>(employee,HttpStatus.NOT_FOUND);
	   }
	 return new ResponseEntity<>(employee,HttpStatus.OK);
	   
   }
	 @PostMapping(path="/")
	   public ResponseEntity<Employee> addStudent(@RequestBody Employee employee) {
			 try {
		  employeeRepository.save(employee);
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
		   if(employee.getId()==0) {
			   return new ResponseEntity<>(employee,HttpStatus.NOT_FOUND);
		   }
		 return new ResponseEntity<>(employee,HttpStatus.OK);
		   
	   }
	 @PutMapping(path="/{id}")
	   public ResponseEntity<Employee> updateStudent(@RequestBody Employee employee,@PathVariable long id) {
			 try {
				 employee =employeeRepository.findById(id).get();
		 
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
		   if(null==employee) {
			   return new ResponseEntity<>(employee,HttpStatus.NOT_FOUND);
		   }else {
			   employee.setId(id);
			  
			  employeeRepository.save(employee);
		   }
		 return new ResponseEntity<>(employee,HttpStatus.OK);
		   
	   }
	 @DeleteMapping(path="/{id}")
	   public ResponseEntity<Long> deleteStudent(@PathVariable long id) {
			
			 try {
				 employeeRepository.deleteById(id);
		   }catch(Exception e) {
			   e.printStackTrace();
			   return new ResponseEntity<>(id,HttpStatus.NOT_FOUND);
		   }
		  
		 return new ResponseEntity<>(id,HttpStatus.OK);
		   
	   }
	 @GetMapping(path="/name/{name}")
	   public ResponseEntity<Employee> getStudentByName(@PathVariable String name) {
			 try {
				 employee =employeeRepository.findByName(name);
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
		   if(null==employee) {
			   return new ResponseEntity<>(employee,HttpStatus.NOT_FOUND);
		   }
		 return new ResponseEntity<>(employee,HttpStatus.OK);
		   
	   }
}
