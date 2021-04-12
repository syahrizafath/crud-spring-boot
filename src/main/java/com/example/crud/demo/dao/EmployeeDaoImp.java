package com.example.crud.demo.dao;

import java.time.LocalDate;
import java.util.List;

import com.example.crud.demo.model.Employee;
import com.example.crud.demo.model.EmployeeMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional

@Repository

public class EmployeeDaoImp implements EmployeeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getAll() {
        String sql = "SELECT * FROM public.employees ORDER BY id ASC ";
        List<Employee> employee = jdbcTemplate.query(sql, new EmployeeMapper());
        return employee;
    }

    @Override
    public Employee getEmployeeById(int id) {
        String sql2 = "select * from public.employees where id = ?";
        Employee employee = jdbcTemplate.queryForObject(sql2, new EmployeeMapper(), id);
        return employee;
    }

    @Override
    public Employee getEmployeeByName(String name) {
        String sql4 = "select * from public.employees where nama = ?";
        try {
            Employee employee = jdbcTemplate.queryForObject(sql4, new EmployeeMapper(), name);
            return employee;
        } catch(Exception e) {
            return null;
        }
    }

    @Override
    public void addEmployee(Employee employee) {
        LocalDate localDate = LocalDate.now();
        String sql = "INSERT INTO public.employees (nama,email,tanggal_masuk,hp,limit_reimbursement,created_date,updated_date) VALUES (?,?,?,?,?,?,?) ";
        jdbcTemplate.update(sql, employee.getNama(), employee.getEmail(), localDate,
                            employee.getHp(), employee.getLimit_reimbursement(),localDate,localDate);
    }

    @Override
    public void updateEmployee(Employee employee, int id) {
        LocalDate localDate = LocalDate.now();
        String sql = "update public.employees set nama = ?, email = ?, tanggal_masuk = ?, hp = ?, limit_reimbursement = ?, updated_date = ? where id = ?";
        jdbcTemplate.update(sql, employee.getNama(), employee.getEmail(), localDate, employee.getHp(),employee.getLimit_reimbursement(), localDate, id);
    }

    @Override
    public void deleteEmployeeById(int id) {
        String sql = "delete from public.employees where id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public int lastestInput() {
        String sql2 = "SELECT currval(pg_get_serial_sequence('public.employees','id'))";
        int id = jdbcTemplate.queryForObject(sql2, Integer.class);
        return id;
    }

    @Override
    public List<Employee> searchEmployee(Employee employee) {
        String sql3 = "";
        if (employee.getTanggal_masuk().isEmpty()) {
            sql3 = "select * from public.employees where nama like '%" + employee.getNama()
                    + "%' and email like '%" + employee.getEmail() + "%' and hp like '%" + employee.getHp()
                    + "%' ORDER BY id ASC";          
        } else {
            sql3 = "select * from public.employees where nama like '%" + employee.getNama()
                    + "%' and email like '%" + employee.getEmail() + "%' and hp like '%" + employee.getHp()
                    + "%' and tanggal_masuk = '" + employee.getTanggal_masuk() + "' ORDER BY id ASC";
        }
        List<Employee> employee2 = jdbcTemplate.query(sql3, new EmployeeMapper());
        return employee2;
    }
}
