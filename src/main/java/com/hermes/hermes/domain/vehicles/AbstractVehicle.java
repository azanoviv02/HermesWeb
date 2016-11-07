package com.hermes.hermes.domain.vehicles;


import com.hermes.hermes.domain.AbstractPersistentObject;
import com.hermes.hermes.domain.hauls.AbstractHaul;

import javax.persistence.*;

/**
 * Created by ivan on 30.10.16.
 */
@Entity
@Table(name = "VEHICLES")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="ENTITY_TYPE", discriminatorType= DiscriminatorType.STRING, length = 20)
@DiscriminatorValue("ABSTRACT_VEHICLE")
public abstract class AbstractVehicle extends AbstractPersistentObject {

    @OneToOne(cascade = CascadeType.PERSIST , fetch = FetchType.EAGER, mappedBy = "assignedVehicle")
    protected AbstractHaul currentHaul;

    public AbstractHaul getCurrentHaul() {
        return currentHaul;
    }

    AbstractVehicle() {
    }
}
