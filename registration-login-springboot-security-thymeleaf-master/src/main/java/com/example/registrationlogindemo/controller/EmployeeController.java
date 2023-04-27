package com.example.registrationlogindemo.controller;

import com.example.registrationlogindemo.dto.CompanyDto;
import com.example.registrationlogindemo.dto.UserDto;
import com.example.registrationlogindemo.entity.Employee;
import com.example.registrationlogindemo.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employeeReg")
    public String showRegistrationFormC(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "addEmployee";
    }

    @GetMapping("/list")
    public String showUpdateForm(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        return "employeeList";
    }

    @PostMapping("/employeeReg")
    public String registrationC(@Valid @ModelAttribute("employee") Employee employee,
                                BindingResult result,
                                Model model){

        if (result.hasErrors()) {
            model.addAttribute("employee", employee);
            return "register";
        }
        employeeRepository.save(employee);
        return "redirect:/list?success";
    }

    @GetMapping("/employees")
    public String listRegisteredUsers(Model model){
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employee", employees);
        return "employees";
    }


    @GetMapping("/aboutUs")
    public String listRegisteredEmployee(Model model){
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employee", employees);
        return "aboutUs";
    }

   /* @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("employee", employee);
        return "update-employee";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") long id, @Valid Employee employee, BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            employee.setId(id);
            return "update-employee";
        }

        employeeRepository.save(employee);
        model.addAttribute("employees", employeeRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteEmployee(@PathVariable("id") long id, Model model) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        employeeRepository.delete(employee);
        model.addAttribute("employees", employeeRepository.findAll());
        return "index";
    }*/
}
