package com.hermes.core.domain.orders;

import com.hermes.core.domain.cargo.CargoFactoryImpl;
import com.hermes.core.domain.cargo.CargoType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ivan on 15.11.16.
 */
@Component
public class OrderFactoryImpl implements OrderFactory{

    @Autowired
    CargoFactoryImpl cargoFactory;

    @Autowired
    OrderBuilderFactory orderBuilderFactory;

    @Override
    public AbstractOrder createBasicOrder(String clientName, CargoType cargoType, double weight, double volume, int amount){
        OrderBuilder orderBuilder = orderBuilderFactory.createOrderBuilder();

        orderBuilder.setClientName(clientName);
        orderBuilder.addCargo(cargoType, weight, volume, amount);
        return orderBuilder.getOrder();
    }
}
