package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollservice implements IEmployeePayrollService{

    private List<EmployeePayrollData> employeePayrollList=new ArrayList();

    public List<EmployeePayrollData> getEmployeePayrollData(){
        return employeePayrollList;
    }

    public EmployeePayrollData getEmployeePayrollDataById(int empId){
        return employeePayrollList.get(empId-1);
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeeDTO empPayrollDTO) {
        EmployeePayrollData empData=null;
        empData=new EmployeePayrollData(employeePayrollList.size()+1, empPayrollDTO);
        employeePayrollList.add(empData);
        return empData;
    }

    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeeDTO empPayrollDTO){
        EmployeePayrollData empData=this.getEmployeePayrollDataById(empId);
        empData.setName(empPayrollDTO.name);
        empData.setSalary(empPayrollDTO.salary);
        employeePayrollList.set(empId-1, empData);
        return empData;
    }
    public void deleteEmployeePayrollData(int empId){
        employeePayrollList.remove(empId-1);
    }
}
