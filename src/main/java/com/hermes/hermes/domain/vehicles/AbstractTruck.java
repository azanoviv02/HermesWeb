package com.hermes.hermes.domain.vehicles;

import javax.persistence.*;

/**
 * Created by ivan on 25.10.16.
 */
@Entity
@DiscriminatorValue("ABSTRACT_TRUCK")
public abstract class AbstractTruck extends AbstractVehicle {

    @Column(name="CUR_WEIGHT")
    protected double currentWeight;

    @Column(name="CUR_VOLUME")
    protected double currentVolume;

    public double getCurrentWeight() {
        return currentWeight;
    }

    public double getCurrentVolume() {
        return currentVolume;
    }

    public double getAvailableWeight() {
        return getMaxWeight()-currentWeight;
    }

    public double getAvailableVolume() {
        return getMaxVolume()-currentVolume;
    }

    public abstract double getMaxWeight();

    public abstract double getMaxVolume();

    AbstractTruck() {
    }
}
