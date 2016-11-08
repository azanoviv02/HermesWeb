package com.hermes.core.domain.vehicles;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by ivan on 25.10.16.
 */
@Entity
@DiscriminatorValue("BASIC_TRUCK")
public class BasicTruck extends AbstractSolidTruck {
    private static double MAX_WEIGHT = 1000.0;
    private static double MAX_VOLUME = 5000.0;

    public BasicTruck() {
        super();
    }

    public double getMaxWeight() {
        return MAX_WEIGHT;
    }

    public double getMaxVolume() {
        return MAX_VOLUME;
    }
}
