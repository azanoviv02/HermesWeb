package com.hermes.core.domain.employees;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by ivan on 25.10.16.
 */
@Entity
@DiscriminatorValue("BASIC_DRIVER")
public class BasicDriver extends AbstractDriver {
    BasicDriver() {
    }

    BasicDriver(String name) {
        super(name);
    }

    BasicDriver(String name, int salary) {
        super(name, salary);
    }
}
