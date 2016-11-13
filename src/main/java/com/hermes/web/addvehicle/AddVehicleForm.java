package com.hermes.web.addvehicle;

import com.hermes.core.domain.places.PlaceType;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class AddVehicleForm {

	private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";

    @NotNull
	@NotBlank(message = AddVehicleForm.NOT_BLANK_MESSAGE)
	private String name;

    @NotNull
	private PlaceType placeType;

    public AddVehicleForm() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlaceType getPlaceType() {
        return placeType;
    }

    public void setPlaceType(PlaceType placeType) {
        this.placeType = placeType;
    }
}
