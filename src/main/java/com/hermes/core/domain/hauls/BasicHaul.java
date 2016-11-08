package com.hermes.core.domain.hauls;


import com.hermes.core.domain.employees.AbstractDriver;
import com.hermes.core.domain.milestones.FinishMilestone;
import com.hermes.core.domain.milestones.StartMilestone;
import com.hermes.core.domain.vehicles.AbstractVehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by ivan on 26.10.16.
 */
@Entity
@DiscriminatorValue("BASIC_HAUL")
public class BasicHaul extends AbstractHaul {
    BasicHaul() {
    }

    public BasicHaul(StartMilestone start, FinishMilestone finish, AbstractDriver assignedDriver, AbstractVehicle assignedVehicle) {
        super(start, finish, assignedDriver, assignedVehicle);
    }

//    public BasicHaul(Milestone start, Milestone finish, Driver assignedDriver, AbstractVehicle assignedVehicle) {
//        super(start, finish, assignedDriver, assignedVehicle);
//    }
}
