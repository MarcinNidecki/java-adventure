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

    public void findEmployeeByLastnameContaining(String string) throws SearchEngineException {

        try {
            LOGGER.info("Looking for employees containing \"" + string  +"\"");
            List<EmployeeDto> employeeList =employeeMapper.mapToEmployeeDtoList(employeeDao.findEmployeeByLastnameContaining(string));

            if(employeeList.size()<1) {
                LOGGER.error(SearchEngineException.ERR_EMPLOYEE_NOT_FOUND);
                throw  new SearchEngineException(SearchEngineException.ERR_EMPLOYEE_NOT_FOUND);
            } else {
                LOGGER.info(employeeList.size() + " user(s) found.");
                for (EmployeeDto foundEmployee: employeeList) {
                    LOGGER.info("Founded Employee Id: " + foundEmployee.getId() + ", " + foundEmployee.getLastname() + " " +foundEmployee.getFirstname());
                }
            }
        } catch (SearchEngineException e) {
            LOGGER.info("We can not  find user using string " + string + " .");
        }
    }


    public void  findCompanyByNameContaining(String containingString) throws SearchEngineException {
        try {
            LOGGER.info("Looking for companies containing \"" + containingString  +"\"");
            List<CompanyDto> companyDtoList =companyMapper.mapToCompanyDtoList(companyDao.findCompaniesByNameContaining(containingString));

            if(companyDtoList.size()<1) {
                LOGGER.error(SearchEngineException.ERR_COMPANY_NOT_FOUND);
                throw  new SearchEngineException(SearchEngineException.ERR_COMPANY_NOT_FOUND);
            } else {
                LOGGER.info(companyDtoList.size() + " companies found.");
                for (CompanyDto foundedCompany: companyDtoList) {
                    LOGGER.info("Founded company: " + foundedCompany.getId() + ", " + foundedCompany.getName() + " ." );
                }
            }
        } catch (SearchEngineException e) {
            LOGGER.info("We can not  find any company cantaining in name  \"" + containingString + "\".");
        }
    }

}
