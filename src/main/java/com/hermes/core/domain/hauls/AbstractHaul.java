package com.hermes.core.domain.hauls;

import com.hermes.core.domain.AbstractPersistentObject;
import com.hermes.core.domain.cargo.AbstractCargo;
import com.hermes.core.domain.employees.AbstractDriver;
import com.hermes.core.domain.milestones.FinishMilestone;
import com.hermes.core.domain.milestones.StartMilestone;
import com.hermes.core.domain.vehicles.AbstractVehicle;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

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

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "haul")
    @Cascade({CascadeType.ALL})
    StartMilestone start;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "haul")
    @Cascade({CascadeType.ALL})
    FinishMilestone finish;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DRIVER_ID", referencedColumnName = "ID")
//    @Cascade({CascadeType.SAVE_UPDATE})
    AbstractDriver assignedDriver;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "VEHICLE_ID", referencedColumnName = "ID")
//    @Cascade({CascadeType.SAVE_UPDATE})
    AbstractVehicle assignedVehicle;

    @OneToMany(mappedBy = "haul")
    @Cascade({CascadeType.SAVE_UPDATE})
    List<AbstractCargo> cargoList;

    AbstractHaul() {
        cargoList = new ArrayList<AbstractCargo>();
    }

    public StartMilestone getStart() {
        if(start == null){
            throw new IllegalStateException("No start");
        }
        return start;
    }

    void setStart(StartMilestone start) {
        this.start = start;
    }

    public FinishMilestone getFinish() {
        if(finish == null){
            throw new IllegalStateException("No finish");
        }
        return finish;
    }

    void setFinish(FinishMilestone finish) {
        this.finish = finish;
    }

    public AbstractDriver getAssignedDriver() {
        if(assignedDriver == null){
            throw new IllegalStateException("No driver");
        }
        return assignedDriver;
    }

    void setAssignedDriver(AbstractDriver assignedDriver) {
        this.assignedDriver = assignedDriver;
    }

    public AbstractVehicle getAssignedVehicle() {
        if(assignedVehicle == null){
            throw new IllegalStateException("No vehicle");
        }
        return assignedVehicle;
    }

    void setAssignedVehicle(AbstractVehicle assignedVehicle) {
        this.assignedVehicle = assignedVehicle;
    }

    public List<AbstractCargo> getCargoList() {
        if(cargoList == null || cargoList.isEmpty()){
            throw new IllegalStateException("No cargo");
        }
        return cargoList;
    }

    void addCargo(AbstractCargo cargo){
        if(cargoList == null){
            throw new IllegalStateException();
        }
        cargo.setHaul(this);
        this.cargoList.add(cargo);
    }
}
