package com.shubham.controller;

import com.shubham.entity.Employee;
import com.shubham.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute(
                "employees",
                service.getAllEmployees()
        );

        return "index";
    }

    @PostMapping("/save")
    public String saveEmployee(
            @ModelAttribute Employee employee) {

        service.saveEmployee(employee);

        return "redirect:/";
    }
}
