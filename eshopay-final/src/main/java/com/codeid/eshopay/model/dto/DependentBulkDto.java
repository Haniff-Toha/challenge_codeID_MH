package com.codeid.eshopay.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DependentBulkDto {
    private Integer employeeId;
    private List<DependentDto> dependents;
}
