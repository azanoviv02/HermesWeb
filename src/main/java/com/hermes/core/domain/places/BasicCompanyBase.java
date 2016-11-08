package com.hermes.core.domain.places;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by ivan on 26.10.16.
 */
@Entity
@DiscriminatorValue("BASIC_COMPANY_BASE")
public class BasicCompanyBase extends AbstractBase {

    BasicCompanyBase() {
    }

    BasicCompanyBase(String name) {
        super(name);
    }
}
