package com.example.registrationlogindemo.controller;

import com.example.registrationlogindemo.dto.CompanyDto;
import com.example.registrationlogindemo.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/registerC")
    public String showRegistrationFormC(Model model){
        CompanyDto company = new CompanyDto();
        model.addAttribute("company", company);
        return "company";
    }

    @PostMapping("/registerC/save")
    public String registrationC(@Valid @ModelAttribute("company") CompanyDto company,
                                BindingResult result,
                                Model model){

        if (result.hasErrors()) {
            model.addAttribute("company", company);
            return "register";
        }

/*        String fileName = fileStorageService.storeFile(gstCertificate);
        company.setGstCertificate(fileName);

        String message = "";

       companyService.saveCompany(company);
        if (gstCertificate.isEmpty()) {
            System.out.println("File is null, please put a gstCertificate ");
        } else {
            message = "File uploaded successfully: " + gstCertificate.getOriginalFilename();
            System.out.println("File uploaded successfully: " + gstCertificate.getOriginalFilename());
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));*/

        companyService.saveCompany(company);
        return "redirect:/employees?success";
    }
}
