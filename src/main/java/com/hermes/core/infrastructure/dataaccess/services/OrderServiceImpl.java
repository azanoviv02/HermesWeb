package com.hermes.core.infrastructure.dataaccess.services;

import com.hermes.core.domain.orders.AbstractOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ivan on 05.11.16.
 */
@Service
public class OrderServiceImpl extends GenericServiceImpl<AbstractOrder> implements OrderService {

    @Autowired
    public OrderServiceImpl(GenericRepository<AbstractOrder> repository) {
        super(repository);
    }
}