package com.ssh.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.service.EmployeeService;
import org.apache.struts2.interceptor.RequestAware;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;



public class EmployeeAction extends ActionSupport implements RequestAware {
    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public String list(){
        request.put("employees",employeeService.getAll());
        return "list";
    }

    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    private InputStream inputStream;

    public InputStream getInputStream(){
        return inputStream;
    }

    public String delete(){
        try {
            employeeService.delete(id);
            inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
        }catch (Exception e){
            e.printStackTrace();
            try {
                inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
        return "delete";
    }

    private Map<String ,Object> request;

    @Override
    public void setRequest(Map<String, Object> map) {
        this.request = map;
    }
}
