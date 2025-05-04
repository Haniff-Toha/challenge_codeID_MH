package com.codeid.eshopper.service.implementation;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.codeid.eshopper.dto.CategoryDto;
import com.codeid.eshopper.entities.Category;
//import com.codeid.eshopper.entities.Category;
import com.codeid.eshopper.repository.CategoryRepository;
import com.codeid.eshopper.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository repository;

    

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }



    @Override
    public List<CategoryDto> findAllCategories() {
        return repository.findAll().stream().map(cat -> {
            var dto = new CategoryDto();
            dto.setCategoryId(cat.getCategoryId());
            dto.setCategoryName(cat.getCategoryName());
            dto.setDescription(cat.getDescription());
            dto.setBase64Image(Base64.getEncoder().encodeToString(cat.getPicture()));
            return dto;
        }).collect(Collectors.toList());
    }



    @Override
    public List<Category> findAllCategory() {
        return repository.findAll();
    }
    
}
