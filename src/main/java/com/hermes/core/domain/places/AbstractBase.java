package com.hermes.core.domain.places;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by ivan on 26.10.16.
 */
@Entity
@DiscriminatorValue("ABSTRACT_BASE")
public abstract class AbstractBase extends AbstractPlace {

    AbstractBase() {
    }

    AbstractBase(String name) {
        super(name);
    }
}
