package com.hermes.hermes.infrastructure.dataaccess.services;

import com.hermes.hermes.domain.vehicles.AbstractVehicle;

/**
 * Created by ivan on 05.11.16.
 */
public class VehicleServiceImpl extends GenericServiceImpl<AbstractVehicle> implements VehicleService {
    public VehicleServiceImpl(GenericRepository<AbstractVehicle> repository) {
        super(repository);
    }
}
