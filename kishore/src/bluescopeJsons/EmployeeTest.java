package com.bluescopeJsons;

import org.junit.jupiter.api.*;

import finezone.CSVToData;
import finezone.ConnectionsJdbc;
import finezone.Employee;
import finezone.QueryToFile;

//import finezone.CSVToDatabase;
//import bluescope.ConnectionsJdbc;
//import bluescope.Employee;
//import bluescope.QueryToFile;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeTest {

    @Test
    @Order(1)
    void testConnectionNotNull() {
        assertDoesNotThrow(() -> {
            Connection conn = ConnectionsJdbc.getConnection();
            assertNotNull(conn, "Connection should not be null");
            conn.close();
        });
    }

    @Test
    @Order(2)
    void testAddEmployee() {
        Employee employee = new Employee("Test Employee", 30, "Engineering");
        assertDoesNotThrow(employee::addEmployee, "Adding a new employee should not throw an exception");
    }

    @Test
    @Order(3)
    void testGetEmployeeById() {
        Employee employee = Employee.getEmployeeById(1); // Assuming ID 1 exists
        assertNotNull(employee, "Employee with ID 1 should exist");
        assertEquals(1, employee.getId(), "Employee ID should match");
    }
//
    @Test
    @Order(4)
    void testUpdateEmployee() {
        Employee employee = new Employee(1, "Updated Name", 35, "Updated Department");
        assertDoesNotThrow(employee::updateEmployee, "Updating employee should not throw an exception");

        Employee updatedEmployee = Employee.getEmployeeById(1);
        assertNotNull(updatedEmployee, "Updated employee should exist");
        assertEquals("Updated Name", updatedEmployee.getName(), "Employee name should be updated");
        assertEquals(35, updatedEmployee.getAge(), "Employee age should be updated");
    }
//
    @Test
    @Order(5)
    void testGetAllEmployees() {
        String employee = Employee.getAllEmployees();
        assertNotNull(employee, "Getting all employees should not return null");
    }
//
    @Test
    @Order(6)
    void testDeleteEmployee() {
        assertDoesNotThrow(() -> Employee.deleteEmployee(27), "Deleting employee should not throw an exception");
        Employee employee = Employee.getEmployeeById(1);
        assertNotNull(employee, "Deleted employee should not exist");
    }
//
    @Test
    @Order(7)
    void testCSVToDatabase() {
        CSVToData csvToDatabase = new CSVToData();
        String csvFilePath = "D:\\Sample/input.csv";
        assertDoesNotThrow(() -> csvToDatabase.loadCSVToDatabase(csvFilePath),
                "Loading valid CSV file should not throw an exception");
    }
//
    @Test
    @Order(8)
    void testQueryToFile() {
        QueryToFile queryToFile = new QueryToFile();
        String query = "SELECT * FROM employee";
        String outputPath = "D:\\Sample/file.txt";
        assertDoesNotThrow(() -> queryToFile.executeQueryAndWriteToFile(query, outputPath),
                "Executing query and writing to file should not throw an exception");
    }

    @Test
    @Order(9)
    void testEmployeeNotFound() {
        Employee employee = Employee.getEmployeeById(-1); // Assuming -1 is an invalid ID
        assertNull(employee, "Employee with invalid ID should return null");
    }

    @Test
    @Order(10)
    void testInvalidCSVFile() {
        CSVToData csvToDatabase = new CSVToData();
        String invalidFilePath = "D:\\Sample/invalid.csv";
        assertThrows(Exception.class, () -> csvToDatabase.loadCSVToDatabase(invalidFilePath),
                "Loading invalid CSV file should throw an exception");
    }
//
    @Test
    @Order(11)
    void testEmptyDatabaseQuery() {
        QueryToFile queryToFile = new QueryToFile();
        String query = "SELECT * FROM bluescope";
        String outputPath = "D:\\Sample/Test.txt";
        assertThrows(SQLException.class, () -> queryToFile.executeQueryAndWriteToFile(query, outputPath),
                "Querying a non-existing table should throw an exception");
    }
}