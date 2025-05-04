package com.codeid.eshopper.service;

import java.util.List;
import java.util.Optional;

import com.codeid.eshopper.entities.Shipper;

public interface ShipperService {
    List<Shipper> findAllShippers();

    Shipper addShipper(Shipper shipper);

    Optional<Shipper> findShipperById(Integer shipperId);

    void deleteShipperById(Integer shipperId);
}
