package com.codeid.eshopper.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "shippers", schema = "oe")
public class Shipper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipper_id")
    private Integer shipperId;

    @Column(name = "company_name")
    @Size(max = 40, message = "Company Name Maksimal 40 Karakter")
    @NotBlank(message="Company Name tidak boleh kosong")
    private String companyName;

    @Column(name = "phone")
    @Size(max = 24, message = "Phone maksimal 24 karakter")
    @NotBlank(message = "Phone tidak boleh kosong")
    private String phone;

    public Shipper() {
    }

    public Shipper(Integer shipperId, @Size(max = 40) String companyName, @Size(max = 24) String phone) {
        this.shipperId = shipperId;
        this.companyName = companyName;
        this.phone = phone;
    }

    public Integer getShipperId() {
        return shipperId;
    }

    public void setShipperId(Integer shipperId) {
        this.shipperId = shipperId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    
}
