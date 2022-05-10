package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeePayrollservice implements IEmployeePayrollService{

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    private List<EmployeePayrollData> employeePayrollList = new ArrayList();

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData(){
        return employeePayrollList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollList.stream()
                .filter(empData->empData.getEmployeeId()==empId)
                .findFirst()
                .orElseThrow(()->new EmployeePayrollException("Employee Not Found"));
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeeDTO empPayrollDTO) {
        EmployeePayrollData empData=null;
        empData = new EmployeePayrollData(empPayrollDTO);
        log.debug("Emp Data: "+empData.toString());
        employeePayrollList.add(empData);
        return employeePayrollRepository.save(empData);
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeeDTO empPayrollDTO){
        EmployeePayrollData empData=this.getEmployeePayrollDataById(empId);
        empData.setName(empPayrollDTO.name);
        empData.setSalary(empPayrollDTO.salary);
        employeePayrollList.set(empId-1, empData);
        return empData;
    }
    @Override
    public void deleteEmployeePayrollData(int empId){
        employeePayrollList.remove(empId-1);
    }
}
