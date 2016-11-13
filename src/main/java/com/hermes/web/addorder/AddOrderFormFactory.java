package com.hermes.web.addorder;

import org.springframework.stereotype.Service;

/**
 * Created by ivan on 13.11.16.
 */
@Service
public class AddOrderFormFactory {

    public OrderForm createOrderForm(){
        return new OrderForm();
    }
}
