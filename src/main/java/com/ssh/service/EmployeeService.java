package com.ssh.service;

import com.ssh.dao.EmployeeDao;
import com.ssh.entities.EmployeeEntity;

import java.util.List;

public class EmployeeService {
    private EmployeeDao employeeDao;
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
    public List<EmployeeEntity> getAll(){
        return employeeDao.getAll();
    }
    public  void  delete(Integer id){
        employeeDao.delete(id);
    }
}
