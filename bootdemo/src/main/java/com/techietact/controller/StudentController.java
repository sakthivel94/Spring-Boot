package com.techietact.controller;

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

import com.techietact.bo.Student;
import com.techietact.repository.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;
	Student student =new Student();
	@GetMapping(path="/")
	public ResponseEntity<List<Student>> getAllEmployees(){
		
		List<Student> studentList=studentRepository.findAll();
		if(null==studentList) {
			return new ResponseEntity<>(studentList,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(studentList,HttpStatus.OK);
	}
	 @GetMapping(path="/{id}")
   public ResponseEntity<Student> getEmployee(@PathVariable long id) {
		 try {
			 student =studentRepository.findById(id).get();
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	   if(null==student) {
		   return new ResponseEntity<>(student,HttpStatus.NOT_FOUND);
	   }
	 return new ResponseEntity<>(student,HttpStatus.OK);
	   
   }
	 @PostMapping(path="/")
	   public ResponseEntity<Student> addStudent(@RequestBody Student student) {
			 try {
				 studentRepository.save(student);
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
		   if(student.getId()==0) {
			   return new ResponseEntity<>(student,HttpStatus.NOT_FOUND);
		   }
		 return new ResponseEntity<>(student,HttpStatus.OK);
		   
	   }
	 @PutMapping(path="/{id}")
	   public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable long id) {
			 try {
				 student =studentRepository.findById(id).get();
		 
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
		   if(null==student) {
			   return new ResponseEntity<>(student,HttpStatus.NOT_FOUND);
		   }else {
			   student.setId(id);
			  
			   studentRepository.save(student);
		   }
		 return new ResponseEntity<>(student,HttpStatus.OK);
		   
	   }
	 @DeleteMapping(path="/{id}")
	   public ResponseEntity<Long> deleteStudent(@PathVariable long id) {
			
			 try {
				 studentRepository.deleteById(id);
		   }catch(Exception e) {
			   e.printStackTrace();
			   return new ResponseEntity<>(id,HttpStatus.NOT_FOUND);
		   }
		  
		 return new ResponseEntity<>(id,HttpStatus.OK);
		   
	   }
	 @GetMapping(path="/name/{name}")
	   public ResponseEntity<Student> getStudentByName(@PathVariable String name) {
			 try {
				 student =studentRepository.findByName(name);
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
		   if(null==student) {
			   return new ResponseEntity<>(student,HttpStatus.NOT_FOUND);
		   }
		 return new ResponseEntity<>(student,HttpStatus.OK);
		   
	   }

}
