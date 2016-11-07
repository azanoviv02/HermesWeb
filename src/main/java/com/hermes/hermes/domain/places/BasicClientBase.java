package com.hermes.hermes.domain.places;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by ivan on 26.10.16.
 */
@Entity
@DiscriminatorValue("BASIC_CLIENT_BASE")
public class BasicClientBase extends AbstractBase {
    BasicClientBase() {
    }

    BasicClientBase(String name) {
        super(name);
    }
}
