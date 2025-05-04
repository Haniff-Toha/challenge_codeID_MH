package com.codeid.eshopper.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codeid.eshopper.entities.Department;
import com.codeid.eshopper.service.CategoryService;
import com.codeid.eshopper.service.DepartmentService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;
    private final CategoryService categoryService;

    public DepartmentController(DepartmentService departmentService, CategoryService categoryService) {
        this.departmentService = departmentService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String findAllDepartment(Model model) {

        model.addAttribute("department", departmentService.findAllDepartments());
        model.addAttribute("category", categoryService.findAllCategory());
        return "/modules/department/department.html";
    }

    @GetMapping("/add")
    public String addDepartment(Model model) {
        model.addAttribute("department", new Department());
        model.addAttribute("action", "Add Department");
        return "modules/department/addEditDepartment.html";
    }

    @PostMapping("/add")
    public String postDepartment(@Valid Department dept, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "modules/department/addEditDepartment.html";
        }
        
        departmentService.addDepartment(dept);

        redirectAttributes.addFlashAttribute("message", "department "+dept.getDepartmentName()+" created!");
        return "redirect:/department/";
    }
    
    @GetMapping("edit/{id}")
	public String editRegionById(@PathVariable("id") Integer departmentId,Model model) {

		Optional<Department> dept = departmentService.findDepartmentById(departmentId);

		model.addAttribute("action", "Edit Department");
		model.addAttribute("department", dept.get());
		return "modules/department/addEditDepartment.html";

	}


    @GetMapping("delete/{id}")
	public String deleteRegion(@PathVariable(name = "id") Integer deptId,RedirectAttributes redirectAttrs) {
		departmentService.deleteDepartmentById(deptId);
		redirectAttrs.addFlashAttribute("message", "DepartmentId "+deptId+" has been delete!");
		return "redirect:/department/";
	}
    
}
