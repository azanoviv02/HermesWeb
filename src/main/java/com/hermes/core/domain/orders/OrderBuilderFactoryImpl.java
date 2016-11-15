package com.hermes.core.domain.orders;

import com.hermes.core.domain.cargo.CargoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ivan on 13.11.16.
 */
@Component
public class OrderBuilderFactoryImpl implements OrderBuilderFactory {

    @Autowired
    CargoFactory cargoFactory;

    @Override
    public OrderBuilder createOrderBuilder(){
        return new OrderBuilder(cargoFactory);
    }
}
