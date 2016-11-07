package com.hermes.hermes.domain.places;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by ivan on 30.10.16.
 */
@Entity
@DiscriminatorValue("BASIC_FIX")
public class BasicFix extends AbstractFix {
    BasicFix() {
    }

    BasicFix(String name) {
        super(name);
    }
}
