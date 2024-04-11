package com.sample.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.Entity.Office;
import com.sample.Repository.OfficeRepository;

@RestController
public class OfficeController {
	
	private OfficeRepository officeRepo;
public OfficeController(OfficeRepository officeRepo) {
		super();
		this.officeRepo = officeRepo;
	}
	List<Office> employeesList= new ArrayList<>();
	@GetMapping(value = "/")
public ResponseEntity<List<Office>> getEmployees(){
	
	try {
		employeesList=officeRepo.findAll();
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	if(employeesList.isEmpty()) {
		return new ResponseEntity<>(employeesList,HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<>(employeesList,HttpStatus.OK);
}
	
}
