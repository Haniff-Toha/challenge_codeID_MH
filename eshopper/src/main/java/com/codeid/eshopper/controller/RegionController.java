package com.codeid.eshopper.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.BindingResult;

import com.codeid.eshopper.entities.Region;
import com.codeid.eshopper.service.CategoryService;
import com.codeid.eshopper.service.RegionService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/region")
public class RegionController {
    private final RegionService regionService;
    private final CategoryService categoryService;

    
    
    public RegionController(RegionService service, CategoryService categoryService) {
        this.regionService = service;
        this.categoryService = categoryService;
    }



    @GetMapping("/")
    public String findAllRegion(Model model) {

        model.addAttribute("regions", regionService.findAllRegions());
        model.addAttribute("category", categoryService.findAllCategory());
        return "/modules/region/region.html";
    }

    @GetMapping("/add")
    public String addRegion(Model model) {
        model.addAttribute("region", new Region());
        model.addAttribute("action", "Add Region");
        return "modules/region/addEditRegion.html";
    }

    @PostMapping("/add")
    public String postRegion(@Valid Region region, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "modules/region/addEditRegion.html";
        }
        
        regionService.addRegion(region);

        redirectAttributes.addFlashAttribute("message", "Region "+region.getRegionName()+" created!");
        return "redirect:/region/";
    }
    
    @GetMapping("edit/{id}")
	public String editRegionById(@PathVariable("id") Integer regionId,Model model) {

		Optional<Region> region = regionService.findRegionById(regionId);

		model.addAttribute("action", "Edit Region");
		model.addAttribute("region", region.get());
		return "modules/region/addEditRegion.html";

	}


    @GetMapping("delete/{id}")
	public String deleteRegion(@PathVariable(name = "id") Integer regionId,RedirectAttributes redirectAttrs) {
		regionService.deleteRegionById(regionId);
		redirectAttrs.addFlashAttribute("message", "RegionId "+regionId+" has been delete!");
		return "redirect:/region/";
	}
}
