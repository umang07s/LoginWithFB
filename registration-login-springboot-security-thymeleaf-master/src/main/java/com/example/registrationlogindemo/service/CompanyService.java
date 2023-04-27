package com.example.registrationlogindemo.service;

import com.example.registrationlogindemo.dto.CompanyDto;
import com.example.registrationlogindemo.entity.Company;

import java.util.List;

public interface    CompanyService {
    void saveCompany(CompanyDto companyDto);

    Company findByEmail(String email);

    List<CompanyDto> findAllCompanies();
}
