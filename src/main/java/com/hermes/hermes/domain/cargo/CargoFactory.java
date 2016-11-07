package com.hermes.hermes.domain.cargo;

import com.hermes.hermes.domain.orders.AbstractOrder;

/**
 * Created by ivan on 02.11.16.
 */
public class CargoFactory {

    private AbstractOrder order;

    public CargoFactory(AbstractOrder order) {
        this.order = order;
    }

    public static CargoFactory newCargoFactory (AbstractOrder order){
        if(order.size() != 0){
            throw new IllegalArgumentException("Can't create factory for existing orders");
        }
        return new CargoFactory(order);
    }

    public AbstractCargo createCargo(String cargoType, double weight, double volume){
        switch (cargoType.toLowerCase()){
            case "box":
                return new Box(order, weight, volume);
            default:
                throw new IllegalArgumentException("Incorrect cargo type");
        }
    }
}
