package com.hermes.core.domain.cargo;

import com.hermes.core.domain.orders.AbstractOrder;

/**
 * Created by ivan on 15.11.16.
 */
public interface CargoFactory {
    void setOrder(AbstractOrder order);

    abstract AbstractCargo createCargo(CargoType cargoType, double weight, double volume);
}
