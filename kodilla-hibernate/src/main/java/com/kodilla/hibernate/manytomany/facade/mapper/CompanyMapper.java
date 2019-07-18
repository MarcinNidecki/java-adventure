package com.kodilla.hibernate.manytomany.facade.mapper;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.facade.CompanyDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompanyMapper {

    public Company mapToCompany(final CompanyDto companyDto) {
        return  new Company(
                companyDto.getId(),
                companyDto.getName(),
                companyDto.getEmployees());

    }

    public CompanyDto mapToCompanyDto(final Company company) {
        return new CompanyDto(
                company.getId(),
                company.getName(),
                company.getEmployees());

    }

    public List<CompanyDto> mapToCompanyDtoList(final List<Company> companiesList){
        return companiesList.stream()
                .map(e -> new CompanyDto(e.getId(),e.getName(), e.getEmployees()))
                .collect(Collectors.toList());
    }
}
