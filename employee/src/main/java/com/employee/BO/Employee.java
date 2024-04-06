package com.employee.BO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
 private long id;
 private String name;
 private String email;
}
