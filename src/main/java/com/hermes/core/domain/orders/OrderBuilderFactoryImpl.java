package com.hermes.core.domain.orders;

import org.springframework.stereotype.Component;

/**
 * Created by ivan on 13.11.16.
 */
@Component
public class OrderBuilderFactoryImpl implements OrderBuilderFactory {

    @Override
    public OrderBuilder createOrderBuilder(){
        return new OrderBuilder();
    }
}
