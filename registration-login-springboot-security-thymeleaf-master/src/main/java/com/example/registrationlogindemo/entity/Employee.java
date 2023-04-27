package com.example.registrationlogindemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {

    @Id
    @SequenceGenerator(name="seq",sequenceName="oracle_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq")
    private long id;

    @NotBlank(message = "FirstName is mandatory")
    @Column(name = "firstName")
    @Size(min = 2 ,max = 10,message = "FirstName should be between 2 to 10 characters")
    private String firstName;

    @NotBlank(message = "LastName is mandatory")
    @Column(name = "lastName")
    @Size(min = 2 ,max = 10,message = "LastName should be between 2 to 10 characters")
    private String lastName;

    @NotBlank(message = "Email is mandatory")
    @Column(name = "email")
    private String email;

    @Column(name = "phone_no")
    private long phoneNo;

    @Column(name = "address")
    @NotBlank(message = "address is mandatory")
    private String address;
}
