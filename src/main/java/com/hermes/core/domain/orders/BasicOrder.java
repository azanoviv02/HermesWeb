package com.hermes.core.domain.orders;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by ivan on 26.10.16.
 */
@Entity
@DiscriminatorValue("BASIC_ORDER")
public class BasicOrder extends AbstractOrder {
    BasicOrder() {
    }
}
