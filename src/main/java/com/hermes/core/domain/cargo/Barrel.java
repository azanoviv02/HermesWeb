package com.hermes.core.domain.cargo;


import com.hermes.core.domain.orders.AbstractOrder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by ivan on 25.10.16.
 */
@Entity
@DiscriminatorValue("BARREL")
public class Barrel extends AbstractSolidCargo {
    Barrel() {
    }

    public Barrel(AbstractOrder order, double weight, double volume) {
        super(null, weight, volume);
    }
}
