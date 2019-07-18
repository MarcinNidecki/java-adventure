package com.kodilla.hibernate.manytomany.facade;

public class SearchEngineException extends Exception {


    public static String ERR_EMPLOYEE_NOT_FOUND = "No employee were found match the specified criteria. Please modify your search criteria and try again.";
    public static String ERR_COMPANY_NOT_FOUND = "No company were found match the specified criteria. Please modify your search criteria and try again.";

    public SearchEngineException(String message) {
        super(message);
    }
}
