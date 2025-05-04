package com.codeid.eshopper.entities;

// import org.hibernate.annotations.JdbcType;
// import org.hibernate.annotations.Type;
// import org.hibernate.type.SqlTypes;

//import org.hibernate.annotations.Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "categories", schema = "oe")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "category_name")
    @Size(max = 15, message = "maximal 15 character")
    private String categoryName;

    @Column(name = "description")
    private String description;

    //@Lob
    // @Type(value = org.hibernate.type.BinaryType.class)
    @Column(name = "picture", columnDefinition = "bytea")
    private byte[] picture;

    public Category(Integer categoryId, @Size(max = 15, message = "maximal 15 character") String categoryName,
            String description, byte[] picture) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.picture = picture;
    }

    
    public Category() {
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

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    
}
