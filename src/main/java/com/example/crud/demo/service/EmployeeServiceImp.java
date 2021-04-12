package com.example.crud.demo.service;

import java.util.List;

import com.example.crud.demo.dao.EmployeeDao;
import com.example.crud.demo.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    public Employee getEmployeeByName(String name) {
        return employeeDao.getEmployeeByName(name);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee, int id) {
        employeeDao.updateEmployee(employee, id);
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeDao.deleteEmployeeById(id);
    }

    @Override
    public int lastestInput() {
        return employeeDao.lastestInput();
    }

    @Override
    public List<Employee> searchEmployee(Employee employee) {
        return employeeDao.searchEmployee(employee);
    }
}
