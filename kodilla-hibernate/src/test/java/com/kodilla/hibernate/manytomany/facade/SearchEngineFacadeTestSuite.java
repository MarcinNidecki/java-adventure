package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import com.kodilla.hibernate.manytomany.facade.mapper.CompanyMapper;
import com.kodilla.hibernate.manytomany.facade.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class SearchEngineFacadeTestSuite {

    @Autowired
    private SearchEngineFacade searchEngine;
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    CompanyMapper companyMapper;

    @Test
    public void testFindEmployeeByLastnameContaining() throws SearchEngineException {
        //Given
        EmployeeDto employeeDto = new EmployeeDto("Marcin","Nidecki");

        //When
        Employee employee = employeeMapper.mapToEmployee(employeeDto);
        employeeDao.save(employee);
        int employeeId = employee.getId();

        //Then
        try {
            searchEngine.findEmployeeByLastnameContaining("dec");
        } catch (SearchEngineException e){

        }
        // Clean Up
        employeeDao.deleteById(employeeId);
    }

    @Test
    public void testFindCompanyByNameContaining() throws SearchEngineException {
        //Given
        CompanyDto companyDto = new CompanyDto("Super UNIQ company");

        //When
        Company company = companyMapper.mapToCompany(companyDto);
        companyDao.save(company);
        int companyId = company.getId();


        System.out.print(companyId);
        //Then
        try {
            searchEngine.findCompanyByNameContaining("IQ");
        } catch (SearchEngineException e){
        }
        // Clean Up
        companyDao.deleteById(companyId);
    }

}
