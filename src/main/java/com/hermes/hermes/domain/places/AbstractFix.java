package com.hermes.hermes.domain.places;

import javax.persistence.*;

/**
 * Created by ivan on 26.10.16.
 */
@Entity
@DiscriminatorValue("ABSTRACT_FIX")
public abstract class AbstractFix extends AbstractPlace {

    AbstractFix() {
    }

    AbstractFix(String name) {
        super(name);
    }
}
