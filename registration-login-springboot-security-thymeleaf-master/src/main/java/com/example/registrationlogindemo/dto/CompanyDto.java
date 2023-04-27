package com.example.registrationlogindemo.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {

    private Long id;

    private String name;

    private String address;

    private String alias;

    private String business;

    private String businessType;

    private String gstNumber;

    private String panCardNumber;

    private String gstCertificate;
}
