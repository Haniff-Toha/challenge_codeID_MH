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

import com.codeid.eshopper.entities.Shipper;
import com.codeid.eshopper.service.CategoryService;
import com.codeid.eshopper.service.ShipperService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/shipper")
public class ShipperController {
    private final ShipperService shipperService;
    private final CategoryService categoryService;
    
    
    public ShipperController(ShipperService shipperService, CategoryService categoryService) {
        this.shipperService = shipperService;
        this.categoryService = categoryService;
    }
    
    @GetMapping("/")
    public String findAllShipper(Model model) {

        model.addAttribute("shipper", shipperService.findAllShippers());
        model.addAttribute("category", categoryService.findAllCategory());
        return "/modules/shipper/shipper.html";
    }

    @GetMapping("/add")
    public String addShipper(Model model) {
        model.addAttribute("shipper", new Shipper());
        model.addAttribute("action", "Add Shipper");
        return "modules/shipper/addEditShipper.html";
    }

    @PostMapping("/add")
    public String postRegion(@Valid Shipper shipper, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "modules/shipper/addEditShipper.html";
        }
        
        shipperService.addShipper(shipper);

        redirectAttributes.addFlashAttribute("message", "Shipper "+shipper.getCompanyName()+" created!");
        return "redirect:/shipper/";
    }
    
    @GetMapping("edit/{id}")
	public String editRegionById(@PathVariable("id") Integer shipperId,Model model, RedirectAttributes redirectAttrs) {

		Optional<Shipper> shipper = shipperService.findShipperById(shipperId);

		model.addAttribute("action", "Edit Region");
		model.addAttribute("shipper", shipper.get());
        redirectAttrs.addFlashAttribute("message", "ShipperID "+shipperId+" has been Updated!");
		return "modules/shipper/addEditShipper.html";

	}


    @GetMapping("delete/{id}")
	public String deleteRegion(@PathVariable(name = "id") Integer shipperId,RedirectAttributes redirectAttrs) {
		shipperService.deleteShipperById(shipperId);
		redirectAttrs.addFlashAttribute("message", "ShipperID "+shipperId+" has been delete!");
		return "redirect:/shipper/";
	}
    
}
