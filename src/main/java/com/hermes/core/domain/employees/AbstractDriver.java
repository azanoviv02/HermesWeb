package com.hermes.core.domain.employees;


import com.hermes.core.domain.hauls.AbstractHaul;

import javax.persistence.*;

/**
 * Created by ivan on 25.10.16.
 */
@Entity
@DiscriminatorValue("ABSTRACT_DRIVER")
public abstract class AbstractDriver extends AbstractEmployee {

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "assignedDriver")
    protected AbstractHaul currentHaul;

    @Embedded
    private DriverLicense driverLicense = new DriverLicense();

    AbstractDriver() {
    }

    AbstractDriver(String name) {
        super(name);
    }

    AbstractDriver(String name, int salary) {
        super(name, salary);
    }

    public AbstractHaul getCurrentHaul() {
        return currentHaul;
    }

    public DriverLicense getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(DriverLicense driverLicense) {
        this.driverLicense = driverLicense;
    }
}
