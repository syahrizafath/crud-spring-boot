package com.example.crud.demo.controller;

import java.util.List;

import com.example.crud.demo.model.Employee;
import com.example.crud.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") int id) {
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<Employee> getByName(@PathVariable("name") String name) {
        Employee employee = employeeService.getEmployeeByName(name);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAll() {
        List<Employee> listEmployee = employeeService.getAll();
        return new ResponseEntity<List<Employee>>(listEmployee, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        Employee employee2 = employeeService.getEmployeeById(employeeService.lastestInput());
        return new ResponseEntity<Employee>(employee2, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        employeeService.updateEmployee(employee, id);
        Employee employee2 = employeeService.getEmployeeById(id);
        return new ResponseEntity<Employee>(employee2, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int id) {
        Employee employee2 = employeeService.getEmployeeById(id);
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<Employee>(employee2, HttpStatus.OK);
    }
    
    @PostMapping("/search")
    public ResponseEntity<List<Employee>> searchEmployee(@RequestBody Employee employee) {
        List<Employee> listEmployee = employeeService.searchEmployee(employee);
        return new ResponseEntity<List<Employee>>(listEmployee, HttpStatus.OK);
    }
}
