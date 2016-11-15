package com.hermes.core.domain.orders;

import com.hermes.core.domain.cargo.CargoType;
import com.hermes.core.domain.places.AbstractPlace;

import java.util.Date;

/**
 * Created by ivan on 15.11.16.
 */
public interface OrderFactory {

    AbstractOrder createBasicOrder(String clientName,
                                   Date startDate,
                                   Date finishDate,
                                   AbstractPlace startPlace,
                                   AbstractPlace finishPlace,
                                   CargoType cargoType,
                                   double weight,
                                   double volume,
                                   int amount);
}
