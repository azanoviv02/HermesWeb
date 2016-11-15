package com.hermes.web.add.addorderflow;

import com.hermes.core.domain.cargo.CargoType;

import java.io.Serializable;

/**
 * Created by ivan on 11.11.16.
 */
public class CargoForm implements Serializable {

    private CargoType cargoType;

    private double weight;

    private double volume;

    private int amount;

    CargoForm() {
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
