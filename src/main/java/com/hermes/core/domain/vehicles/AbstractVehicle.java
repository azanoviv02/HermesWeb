package com.hermes.core.domain.vehicles;


import com.hermes.core.domain.AbstractPersistentObject;
import com.hermes.core.domain.hauls.AbstractHaul;

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

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "assignedVehicle")
    protected AbstractHaul currentHaul;

    AbstractVehicle() {
    }

    public String getVehicleType() {
        if(this instanceof BasicTruck){
            return "Basic truck";
        }else{
            throw new IllegalStateException();
        }
    }

    public AbstractHaul getCurrentHaul() {
        return currentHaul;
    }

    void setCurrentHaul(AbstractHaul currentHaul) {
        this.currentHaul = currentHaul;
    }
}
