package com.hermes.core.domain.hauls;

import com.hermes.core.domain.cargo.AbstractCargo;
import com.hermes.core.domain.employees.AbstractDriver;
import com.hermes.core.domain.milestones.FinishMilestone;
import com.hermes.core.domain.milestones.MilestoneFactory;
import com.hermes.core.domain.milestones.StartMilestone;
import com.hermes.core.domain.places.AbstractPlace;
import com.hermes.core.domain.vehicles.AbstractVehicle;

import java.util.Date;
import java.util.List;

/**
 * Created by ivan on 02.11.16.
 */
public class HaulBuilder {

    private MilestoneFactory milestoneFactory;
    private AbstractHaul newHaul;

    HaulBuilder() {
    }

    HaulBuilder(MilestoneFactory milestoneFactory) {
        this.milestoneFactory = milestoneFactory;
        newHaul = new BasicHaul();
    }

    public void setStart(StartMilestone start) {
        newHaul.setStart(start);
    }

    public void setStart(Date date, AbstractPlace startPlace) {
        newHaul.setStart(milestoneFactory.createStartMilestone(date, startPlace));
    }

    public void setFinish(FinishMilestone finish) {
        newHaul.setFinish(finish);
    }

    public void setFinish(Date date, AbstractPlace finishPlace) {
        if(date == null){
            System.out.println("No date in builder!");
        }
        newHaul.setFinish(milestoneFactory.createFinishMilestone(date, finishPlace));
    }

    public void setAssignedDriver(AbstractDriver assignedDriver) {
        System.out.println(assignedDriver.getName());
        newHaul.setAssignedDriver(assignedDriver);
    }

    public void setAssignedVehicle(AbstractVehicle assignedVehicle) {
        newHaul.setAssignedVehicle(assignedVehicle);
    }

    public void addCargo(AbstractCargo cargo){
        newHaul.addCargo(cargo);
    }

    public void addAllCargo(List<AbstractCargo> cargoList){
        for(AbstractCargo cargo : cargoList){
            newHaul.addCargo(cargo);
        }
    }

    public AbstractHaul getHaul(){
//        try{
            newHaul.getStart();
            newHaul.getFinish();
            newHaul.getAssignedDriver();
            newHaul.getAssignedVehicle();
            newHaul.getCargoList();
//        }catch (IllegalStateException ise){
//            throw new IllegalStateException("Haul is not ready yet!");
//        }
        return newHaul;
    }
}
