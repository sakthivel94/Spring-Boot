package com.sample.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sample.Controller.OfficeController;
import com.sample.Entity.Office;
import com.sample.Repository.OfficeRepository;

public class OfficeControllerTest {

    private OfficeController officeController;
    private OfficeRepository officeRepo;

    @BeforeEach
    public void setUp() {
        officeRepo = mock(OfficeRepository.class);
        officeController = new OfficeController(officeRepo);
    }

    @Test
    public void testGetEmployeesReturnsListOfEmployees() {
        // Arrange
        List<Office> mockEmployeesList = new ArrayList<>();
        Office office1 = new Office();
        office1.setId(1L);
        office1.setName("Office 1");
        office1.setEmail("office1@example.com");
        mockEmployeesList.add(office1);

        when(officeRepo.findAll()).thenReturn(mockEmployeesList);

        // Act
        ResponseEntity<List<Office>> response = officeController.getEmployees();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockEmployeesList, response.getBody());
    }

    @Test
    public void testGetEmployeesReturnsNotFoundWhenListIsEmpty() {
        // Arrange
        List<Office> emptyList = new ArrayList<>();
        when(officeRepo.findAll()).thenReturn(emptyList);

        // Act
        ResponseEntity<List<Office>> response = officeController.getEmployees();

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(emptyList, response.getBody());
    }

//    @Test
//    public void testGetEmployeesHandlesException() {
//        // Arrange
//        when(officeRepo.findAll()).thenThrow(new RuntimeException("Database error"));
//
//        // Act
//        ResponseEntity<List<Office>> response = officeController.getEmployees();
//
//        // Assert
//        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//        assertEquals(null, response.getBody()); // Body will be null in case of exception
//    }
}
