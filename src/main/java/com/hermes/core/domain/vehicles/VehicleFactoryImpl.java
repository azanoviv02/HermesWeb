package com.hermes.core.domain.vehicles;

import org.springframework.stereotype.Component;

/**
 * Created by ivan on 05.11.16.
 */
@Component
public class VehicleFactoryImpl implements VehicleFactory {

    public VehicleFactoryImpl() {
    }

    @Override
    public BasicTruck createBasicTruck(){
        return new BasicTruck();
    }
}
