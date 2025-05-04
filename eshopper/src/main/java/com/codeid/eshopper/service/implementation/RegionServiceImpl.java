package com.codeid.eshopper.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codeid.eshopper.entities.Region;
import com.codeid.eshopper.repository.RegionRepository;
import com.codeid.eshopper.service.RegionService;

@Service
public class RegionServiceImpl implements RegionService{
    //untuk inject constructor
    private final RegionRepository repository;


    //depedency Injection
    public RegionServiceImpl(RegionRepository repository) {
        //loose-couple
        this.repository = repository;

        //contoh tight-couple
        //this.repository = new RegionRepository();
    }


    @Override
    public List<Region> findAllRegions() {
        return repository.findAll();
    }


    @Override
    public Region addRegion(Region region) {
        return repository.save(region);
    }


    @Override
    public Optional<Region> findRegionById(Integer regionId) {
        return repository.findById(regionId);
    }


    @Override
    public void deleteRegionById(Integer regionId) {
        repository.deleteById(regionId);
    }
    
}
