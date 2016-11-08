package com.hermes.core.domain.cargo;


import com.hermes.core.domain.orders.AbstractOrder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by ivan on 30.10.16.
 */
@Entity
@DiscriminatorValue("ABSTRACT_SOLID_CARGO")
public abstract class AbstractSolidCargo extends AbstractCargo {
    AbstractSolidCargo() {
    }

    public AbstractSolidCargo(AbstractOrder order, double weight, double volume) {
        super(order, weight, volume);
    }
}
