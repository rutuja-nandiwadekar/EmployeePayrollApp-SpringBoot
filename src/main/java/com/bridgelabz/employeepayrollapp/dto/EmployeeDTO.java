package com.bridgelabz.employeepayrollapp.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class EmployeeDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",
            message = "Employee name is Invalid")

    @NotEmpty(message = "Employee name cannot be null")
    public String name;
    @Min(value = 500, message = "Min wage should be more than 500")
    public long salary;


    public EmployeeDTO(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
        public String toString() {
            return "name="+name+":salary="+salary;
        }
}
