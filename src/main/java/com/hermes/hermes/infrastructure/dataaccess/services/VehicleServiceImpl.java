package com.hermes.hermes.infrastructure.dataaccess.services;

import com.hermes.hermes.domain.vehicles.AbstractVehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ivan on 05.11.16.
 */

@Service
public class VehicleServiceImpl extends GenericServiceImpl<AbstractVehicle> implements VehicleService {

    @Autowired
    public VehicleServiceImpl(GenericRepository<AbstractVehicle> repository) {
        super(repository);
    }
}
