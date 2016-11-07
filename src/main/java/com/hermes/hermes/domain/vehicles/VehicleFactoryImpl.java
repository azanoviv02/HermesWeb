package com.hermes.hermes.domain.vehicles;

/**
 * Created by ivan on 05.11.16.
 */
public class VehicleFactoryImpl implements VehicleFactory {

    public VehicleFactoryImpl() {
    }

    @Override
    public BasicTruck createBasicTruck(){
        return new BasicTruck();
    }
}
