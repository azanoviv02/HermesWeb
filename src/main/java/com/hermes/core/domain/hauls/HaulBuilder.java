package com.hermes.core.domain.hauls;

import com.hermes.core.domain.cargo.AbstractCargo;
import com.hermes.core.domain.employees.AbstractEmployee;
import com.hermes.core.domain.places.AbstractPlace;
import com.hermes.core.domain.vehicles.AbstractVehicle;
import com.hermes.core.infrastructure.dataaccess.services.HaulService;

import java.util.Date;
import java.util.List;

/**
 * Created by ivan on 02.11.16.
 */
public class HaulBuilder {

    private AbstractHaul newHaul;
    private HaulService haulService;

    HaulBuilder(HaulService haulService) {
        this.newHaul = new BasicHaul();
        this.haulService = haulService;
        haulService.add(newHaul);
    }

    public void setStart(Date date, AbstractPlace startPlace) {
        newHaul.setStartDate(date);
        newHaul.setStartPlace(startPlace);
    }

    public void setFinish(Date date, AbstractPlace finishPlace) {
        newHaul.setFinishDate(date);
        newHaul.setFinishPlace(finishPlace);
    }

    public void setAssignedDriver(AbstractEmployee assignedDriver) {
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
        try{
            newHaul.getStartDate();
            newHaul.getFinishDate();
            newHaul.getStartPlace();
            newHaul.getFinishPlace();
            newHaul.getAssignedDriver();
            newHaul.getAssignedVehicle();
//            newHaul.getCargoList();
        }catch (IllegalStateException ise){
            throw new IllegalStateException("Haul is not ready yet!");
        }
        return newHaul;
    }
}
