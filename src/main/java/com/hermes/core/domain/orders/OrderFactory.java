package com.hermes.core.domain.orders;

import com.hermes.core.domain.cargo.CargoType;

import java.util.Date;

/**
 * Created by ivan on 15.11.16.
 */
public interface OrderFactory {
    abstract AbstractOrder createBasicOrder(String clientName,
                                            Date startDate,
                                            Date finishDate,
                                            CargoType cargoType,
                                            double weight,
                                            double volume,
                                            int amount);
}
