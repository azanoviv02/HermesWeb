package com.hermes.core.domain.hauls;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by ivan on 26.10.16.
 */
@Entity
@DiscriminatorValue("BASIC_HAUL")
public class BasicHaul extends AbstractHaul {

    public BasicHaul() {
    }
}
