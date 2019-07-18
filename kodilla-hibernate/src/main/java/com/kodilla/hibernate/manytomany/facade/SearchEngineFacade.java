package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import com.kodilla.hibernate.manytomany.facade.mapper.CompanyMapper;
import com.kodilla.hibernate.manytomany.facade.mapper.EmployeeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchEngineFacade {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    CompanyMapper companyMapper;


    private static final Logger LOGGER = LoggerFactory.getLogger(SearchEngineFacade.class);

    public List<EmployeeDto> findEmployeeByLastnameContaining(String string) throws SearchEngineException {
        LOGGER.info("Looking for employees containing \"" + string  +"\"");
        List<EmployeeDto> employeeList =employeeMapper.mapToEmployeeDtoList(employeeDao.findEmployeeByLastnameContaining(string));
            if(employeeList.isEmpty()) {
                LOGGER.error(SearchEngineException.ERR_EMPLOYEE_NOT_FOUND);
                throw  new SearchEngineException(SearchEngineException.ERR_EMPLOYEE_NOT_FOUND);
            }
            return employeeList;
    }


    public List<CompanyDto> findCompanyByNameContaining(String containingString) throws SearchEngineException {
        LOGGER.info("Looking for companies containing \"" + containingString  +"\"");
        List<CompanyDto> companyDtoList =companyMapper.mapToCompanyDtoList(companyDao.findCompaniesByNameContaining(containingString));
            if(companyDtoList.isEmpty()) {
                LOGGER.error(SearchEngineException.ERR_COMPANY_NOT_FOUND);
                throw  new SearchEngineException(SearchEngineException.ERR_COMPANY_NOT_FOUND);
            }
            return companyDtoList;
    }
}
