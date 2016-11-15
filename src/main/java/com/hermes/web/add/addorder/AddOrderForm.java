package com.hermes.web.add.addorder;


import com.hermes.core.domain.cargo.CargoType;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by ivan on 11.11.16.
 */
public class AddOrderForm implements Serializable {

    @NotNull
    private String clientName;

    @NotNull
    private CargoType cargoType;

    @NotNull
    private double weight;

    @NotNull
    private double volume;

    @NotNull
    private int amount;

    public AddOrderForm() {
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public CargoType getCargoType() {
        return cargoType;
    }

    public void setCargoType(CargoType cargoType) {
        this.cargoType = cargoType;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
