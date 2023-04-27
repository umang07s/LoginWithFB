package com.example.registrationlogindemo.service;

import com.example.registrationlogindemo.dto.CompanyDto;
import com.example.registrationlogindemo.entity.Company;
import com.example.registrationlogindemo.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class companyServiceImpl implements CompanyService {


    private CompanyRepository companyRepository;

    public companyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public void saveCompany(CompanyDto companyDto) {
        Company company = new Company();
        company.setName(companyDto.getName());
        company.setAddress(companyDto.getAddress());
        company.setBusiness(companyDto.getBusiness());
        company.setBusinessType(companyDto.getBusinessType());
        company.setAlias(companyDto.getAlias());
        company.setGstNumber(companyDto.getGstNumber());
        company.setPanCardNumber(companyDto.getPanCardNumber());
        company.setGstCertificate(companyDto.getGstCertificate());

        companyRepository.save(company);
    }

    @Override
    public Company findByEmail(String email) {
        return null;
    }

    @Override
    public List<CompanyDto> findAllCompanies() {
        List<Company> companies = companyRepository.findAll();
        return companies.stream().map((company) -> convertEntityToDto(company))
                .collect(Collectors.toList());
    }

    private CompanyDto convertEntityToDto(Company company){
        CompanyDto companyDto = new CompanyDto();
//        String[] name = company.getName().split(" ");
        companyDto.setName(company.getName());
        companyDto.setAddress(company.getAddress());
        companyDto.setAlias(company.getAlias());
        companyDto.setBusiness(company.getBusiness());
        companyDto.setBusinessType(company.getBusinessType());
        companyDto.setGstNumber(company.getGstNumber());
        companyDto.setPanCardNumber(company.getPanCardNumber());
        companyDto.setGstCertificate(company.getGstCertificate());
        return companyDto;
    }
}
