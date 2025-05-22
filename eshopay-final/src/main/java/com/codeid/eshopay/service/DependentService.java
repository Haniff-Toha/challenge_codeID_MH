package com.codeid.eshopay.service;

import java.util.List;

import com.codeid.eshopay.model.dto.DependentBulkDto;
import com.codeid.eshopay.model.dto.DependentDto;

public interface DependentService extends BaseCrudService<DependentDto, Integer>{
    List<DependentDto> findDependentByEmployeeId(Integer id);
    List<DependentDto> bulkInsert(DependentBulkDto dependentBulkDto);
}
