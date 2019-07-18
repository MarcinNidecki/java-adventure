package com.kodilla.hibernate.manytomany.facade.mapper;

import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.facade.EmployeeDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {

    public Employee mapToEmployee(final EmployeeDto employeeDto) {
        return  new Employee(
                employeeDto.getId(),
                employeeDto.getFirstname(),
                employeeDto.getLastname(),
                employeeDto.getCompanies());

    }

    public EmployeeDto mapToEmployeeDto(final Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstname(),
                employee.getLastname(),
                employee.getCompanies());

    }

    public List<EmployeeDto> mapToEmployeeDtoList(final List<Employee> employeeList){
        return employeeList.stream()
                .map(e -> new EmployeeDto(e.getId(),e.getFirstname(), e.getLastname(),e.getCompanies()))
                .collect(Collectors.toList());
    }
}
