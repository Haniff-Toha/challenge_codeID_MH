package com.codeid.eshopay.model.dto;

import com.codeid.eshopay.model.enumeration.EnumRelationship;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DependentDto {
    private Integer dependentId;

    @Size(max=50, message = "Lenght maximal 50")
    private String firstName;

    private String lastName;
    
    private EnumRelationship relationship;

    private Integer employeeId;
}