package com.example.crud.demo.service;

import java.util.List;

import com.example.crud.demo.model.Employee;

public interface EmployeeService {
    List<Employee> getAll();
    Employee getEmployeeById(int id);
    Employee getEmployeeByName(String name);
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee, int id);
    void deleteEmployeeById(int id);
    List<Employee> searchEmployee(Employee employee);
    int lastestInput();
}
