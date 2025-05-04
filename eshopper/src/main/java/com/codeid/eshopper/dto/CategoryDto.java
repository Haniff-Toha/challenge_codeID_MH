package com.codeid.eshopper.dto;

public class CategoryDto {
    private Integer categoryId;
    private String categoryName;
    private String description;
    private String base64Image;
    
    
    public CategoryDto() {    }


    public CategoryDto(Integer categoryId, String categoryName, String description, String base64Image) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.base64Image = base64Image;
    }


    public Integer getCategoryId() {
        return categoryId;
    }


    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }


    public String getCategoryName() {
        return categoryName;
    }


    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getBase64Image() {
        return base64Image;
    }


    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    
}
