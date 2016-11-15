package com.hermes.core.domain.orders;

import com.hermes.core.domain.cargo.CargoType;

/**
 * Created by ivan on 15.11.16.
 */
public interface OrderFactory {
    AbstractOrder createBasicOrder(String clientName, CargoType cargoType, double weight, double volume, int amount);
}
