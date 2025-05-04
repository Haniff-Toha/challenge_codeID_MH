package com.codeid.eshopper.controller;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codeid.eshopper.model.Employee;
import com.codeid.eshopper.service.CategoryService;
//import com.codeid.eshopper.service.DepartmentService;



@Controller
@RequestMapping("index")
public class IndexController {

    private final CategoryService categoryService;
    //private final DepartmentService departmentService;

    
    public IndexController(CategoryService categoryService) {
        this.categoryService = categoryService;
        //this.departmentService = departmentService;
    }

    @GetMapping("/")
    public String showIndex(Model model){
        model.addAttribute("title", "Beli Mie Ayam yuk");
        model.addAttribute("category", categoryService.findAllCategory());
        //model.addAttribute("department2", departmentService.findAllDepartments());
        return "index";
    }

    @GetMapping("/employee")
    public String showEmployee(Model model) {
        var emp1 = new Employee("Widi", LocalDate.of(2025, 1, 1), 4_000);
        var emp2 = new Employee("Hanip", LocalDate.of(2025, 1, 1), 5_000);
        
        var emps = Arrays.asList(emp1, emp2);

        model.addAttribute("employees", emps);

        return "employee";
    }
    
}
