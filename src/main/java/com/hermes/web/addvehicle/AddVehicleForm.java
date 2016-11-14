package com.hermes.web.addvehicle;

import com.hermes.core.domain.vehicles.VehicleType;

import javax.validation.constraints.NotNull;

public class AddVehicleForm {

    @NotNull
	private VehicleType vehicleType;

    public AddVehicleForm() {
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
