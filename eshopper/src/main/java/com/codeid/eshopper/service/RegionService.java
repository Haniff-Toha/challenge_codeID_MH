package com.codeid.eshopper.service;

import java.util.List;
import java.util.Optional;

import com.codeid.eshopper.entities.Region;

public interface RegionService {
    List<Region> findAllRegions();

    Region addRegion(Region region);

    Optional<Region> findRegionById(Integer regionId);

    void deleteRegionById(Integer regionId);
}
