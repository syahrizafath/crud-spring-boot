package com.example.crud.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee>{
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setKode(rs.getString("kode"));
        employee.setNama(rs.getString("nama"));
        employee.setEmail(rs.getString("email"));
        employee.setTanggal_masuk(rs.getString("tanggal_masuk"));
        employee.setHp(rs.getString("hp"));
        employee.setLimit_reimbursement(rs.getInt("limit_reimbursement"));

        return employee;
    }
}
