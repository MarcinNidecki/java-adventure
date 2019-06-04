package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest


public class EmployeeDaoTestSuite {

    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testFindEmployeeByName(){
        //Given
        Employee johnSmith = new Employee("John", "Smith");

        //When
        employeeDao.save(johnSmith);
        int johnSmithId = johnSmith.getId();
        List<Employee> employeeList =employeeDao.findEmployeeByName("Smith");

        //Then
        Assert.assertEquals(1,employeeList.size());

        //CleanUp
        employeeDao.deleteById(johnSmithId);
    }
}

