package com.codeid.eshopper.service;

import java.util.List;

import com.codeid.eshopper.dto.CategoryDto;
import com.codeid.eshopper.entities.Category;

public interface CategoryService {
    List<CategoryDto> findAllCategories();
    List<Category> findAllCategory();
}
