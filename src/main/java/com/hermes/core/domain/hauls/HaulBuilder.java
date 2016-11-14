package com.hermes.core.domain.hauls;

import com.hermes.core.domain.cargo.AbstractCargo;
import com.hermes.core.domain.employees.AbstractDriver;
import com.hermes.core.domain.milestones.FinishMilestone;
import com.hermes.core.domain.milestones.MilestoneFactory;
import com.hermes.core.domain.milestones.MilestoneFactoryImpl;
import com.hermes.core.domain.milestones.StartMilestone;
import com.hermes.core.domain.places.AbstractBase;
import com.hermes.core.domain.vehicles.AbstractVehicle;

import java.util.Calendar;

/**
 * Created by ivan on 02.11.16.
 */
public class HaulBuilder {

    private MilestoneFactory milestoneFactory;
    private AbstractHaul newHaul;

    HaulBuilder() {
        System.out.println("Somehow here");
        this.milestoneFactory = new MilestoneFactoryImpl();
        newHaul = new BasicHaul();
    }

    HaulBuilder(MilestoneFactory milestoneFactory) {
        this.milestoneFactory = milestoneFactory;
        newHaul = new BasicHaul();
    }

    void setStart(StartMilestone start) {
        newHaul.setStart(start);
    }

    void setStart(Calendar date, AbstractBase startBase) {
        newHaul.setStart(milestoneFactory.createStartMilestone(date, startBase));
    }

    void setFinish(FinishMilestone finish) {
        newHaul.setFinish(finish);
    }

    void setFinish(Calendar date, AbstractBase finishBase) {
        newHaul.setFinish(milestoneFactory.createFinishMilestone(date, finishBase));
    }

    public AbstractDriver getAssignedDriver() {
        try {
            return newHaul.getAssignedDriver();
        } catch (IllegalStateException e) {
            return null;
        }
    }

    void setAssignedDriver(AbstractDriver assignedDriver) {
        System.out.println(assignedDriver.getName());
        newHaul.setAssignedDriver(assignedDriver);
    }

    void setAssignedVehicle(AbstractVehicle assignedVehicle) {
        newHaul.setAssignedVehicle(assignedVehicle);
    }

    void addCargo(AbstractCargo cargo){
        newHaul.addCargo(cargo);
    }

    public AbstractHaul getHaul(){
        try{
//            newHaul.getStart();
//            newHaul.getFinish();
            newHaul.getAssignedDriver();
//            newHaul.getAssignedVehicle();
//            newHaul.getCargoList();
        }catch (IllegalStateException ise){
            throw new IllegalStateException("Haul is not ready yet!");
        }
        return newHaul;
    }
}
