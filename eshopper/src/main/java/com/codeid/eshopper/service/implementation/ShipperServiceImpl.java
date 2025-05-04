package com.codeid.eshopper.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codeid.eshopper.entities.Shipper;
import com.codeid.eshopper.repository.ShipperRepository;
import com.codeid.eshopper.service.ShipperService;

@Service
public class ShipperServiceImpl implements ShipperService{
    private final ShipperRepository shipperRepository;

    

    public ShipperServiceImpl(ShipperRepository shipperRepository) {
        this.shipperRepository = shipperRepository;
    }

    @Override
    public List<Shipper> findAllShippers() {
        return shipperRepository.findAll();
    }

    @Override
    public Shipper addShipper(Shipper shipper) {
        return shipperRepository.save(shipper);
    }

    @Override
    public Optional<Shipper> findShipperById(Integer shipperId) {
        return shipperRepository.findById(shipperId);
    }

    @Override
    public void deleteShipperById(Integer shipperId) {
        shipperRepository.deleteById(shipperId);
    }
    
}
