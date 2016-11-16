package com.hermes.core.domain.hauls;

import com.hermes.core.domain.AbstractPersistentObject;
import com.hermes.core.domain.cargo.AbstractCargo;
import com.hermes.core.domain.employees.AbstractDriver;
import com.hermes.core.domain.employees.AbstractEmployee;
import com.hermes.core.domain.places.AbstractPlace;
import com.hermes.core.domain.vehicles.AbstractVehicle;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
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

    @Temporal(TemporalType.DATE)
    @Column(name="START_DATE")
    Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name="FINISH_DATE")
    Date finishDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "START_PLACE_ID")
//    @Cascade({CascadeType.SAVE_UPDATE})
    AbstractPlace startPlace;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FINISH_PLACE_ID")
//    @Cascade({CascadeType.SAVE_UPDATE})
    AbstractPlace finishPlace;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DRIVER_ID", referencedColumnName = "ID")
//    @Cascade({CascadeType.SAVE_UPDATE})
    AbstractDriver assignedDriver;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "VEHICLE_ID", referencedColumnName = "ID")
//    @Cascade({CascadeType.SAVE_UPDATE})
    AbstractVehicle assignedVehicle;

    @Enumerated(EnumType.STRING)
    @Column(name="STATUS", nullable = false)
    HaulStatus haulStatus = HaulStatus.CREATED;

    @OneToMany(mappedBy = "haul")
//    @Cascade({CascadeType.PERSIST})
    List<AbstractCargo> cargoList;



    AbstractHaul() {
        cargoList = new ArrayList<AbstractCargo>();
    }

    public Date getStartDate() {
        if(assignedDriver == null){
            throw new IllegalStateException("No start date");
        }
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        if(assignedDriver == null){
            throw new IllegalStateException("No finish date");
        }
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public AbstractPlace getStartPlace() {
        if(assignedDriver == null){
            throw new IllegalStateException("No start place");
        }
        return startPlace;
    }

    public void setStartPlace(AbstractPlace startPlace) {
        this.startPlace = startPlace;
    }

    public AbstractPlace getFinishPlace() {
        if(assignedDriver == null){
            throw new IllegalStateException("No finish place");
        }
        return finishPlace;
    }

    public void setFinishPlace(AbstractPlace finishPlace) {
        this.finishPlace = finishPlace;
    }

    public AbstractEmployee getAssignedDriver() {
        if(assignedDriver == null){
            throw new IllegalStateException("No driver");
        }
        return assignedDriver;
    }

    public void setAssignedDriver(AbstractEmployee assignedDriver) {
        if(assignedDriver instanceof AbstractDriver){
            this.assignedDriver = (AbstractDriver) assignedDriver;
        }else{
            throw new IllegalStateException("Only drivers are accepted");
        }

    }

    public AbstractVehicle getAssignedVehicle() {
        if(assignedVehicle == null){
            throw new IllegalStateException("No vehicle");
        }
        return assignedVehicle;
    }

    public void setAssignedVehicle(AbstractVehicle assignedVehicle) {
        this.assignedVehicle = assignedVehicle;
    }

    public HaulStatus getHaulStatus() {
        return haulStatus;
    }

    public void setHaulStatus(HaulStatus haulStatus) {
        if(haulStatus == HaulStatus.NOTEXISTS){
            throw new IllegalArgumentException();
        }
        this.haulStatus = haulStatus;
    }

    public List<AbstractCargo> getCargoList() {
        if(cargoList == null || cargoList.isEmpty()){
            throw new IllegalStateException("No cargo");
        }
        return cargoList;
    }

    public void addCargo(AbstractCargo cargo){
        if(cargoList == null){
            throw new IllegalStateException();
        }
        cargo.setHaul(this);
        this.cargoList.add(cargo);
    }
}
