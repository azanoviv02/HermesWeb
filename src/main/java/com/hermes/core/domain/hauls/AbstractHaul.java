package com.hermes.core.domain.hauls;

import com.hermes.core.domain.AbstractPersistentObject;
import com.hermes.core.domain.cargo.AbstractCargo;
import com.hermes.core.domain.employees.AbstractDriver;
import com.hermes.core.domain.milestones.AbstractMilestone;
import com.hermes.core.domain.milestones.FinishMilestone;
import com.hermes.core.domain.milestones.StartMilestone;
import com.hermes.core.domain.vehicles.AbstractVehicle;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan on 26.10.16.
 */
@Entity
@Table(name="HAULS")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="ENTITY_TYPE", discriminatorType= DiscriminatorType.STRING, length = 20)
@DiscriminatorValue("ABSTRACT_HAUL")
public abstract class AbstractHaul extends AbstractPersistentObject {

    @OneToOne(cascade = CascadeType.PERSIST , fetch = FetchType.EAGER, mappedBy = "haul")
    protected StartMilestone start;

    @OneToOne(cascade = CascadeType.PERSIST , fetch = FetchType.EAGER, mappedBy = "haul")
    protected FinishMilestone finish;

    @OneToOne(cascade = CascadeType.PERSIST , fetch = FetchType.EAGER)
    @JoinColumn(name = "DRIVER_ID", referencedColumnName = "ID")
    protected AbstractDriver assignedDriver;

    @OneToOne(cascade = CascadeType.PERSIST , fetch = FetchType.EAGER)
    @JoinColumn(name = "VEHICLE_ID", referencedColumnName = "ID")
    protected AbstractVehicle assignedVehicle;

    @OneToMany(mappedBy = "haul")
    protected List<AbstractCargo> cargoList;

    public AbstractMilestone getStart() {
        return start;
    }

    public AbstractMilestone getFinish() {
        return finish;
    }

    public AbstractDriver getAssignedDriver() {
        return assignedDriver;
    }

    public AbstractVehicle getAssignedVehicle() {
        return assignedVehicle;
    }

    public List<AbstractCargo> getCargoList() {
        return cargoList;
    }

    public void addCargo(AbstractCargo cargo){
        cargo.setHaul(this);
        this.cargoList.add(cargo);
    }

    AbstractHaul() {
    }

    public AbstractHaul(StartMilestone start, FinishMilestone finish, AbstractDriver assignedDriver, AbstractVehicle assignedVehicle) {
        this.start = start;
        start.setHaul(this);
        this.finish = finish;
        finish.setHaul(this);
        this.assignedDriver = assignedDriver;
        this.assignedVehicle = assignedVehicle;
        this.cargoList = new ArrayList<>();
    }

//    public AbstractHaul(Milestone start, Milestone finish, Driver assignedDriver, AbstractVehicle assignedVehicle) {
//        this.start = start;
//        this.finish = finish;
//        this.assignedDriver = assignedDriver;
//        this.assignedVehicle = assignedVehicle;
//    }
}