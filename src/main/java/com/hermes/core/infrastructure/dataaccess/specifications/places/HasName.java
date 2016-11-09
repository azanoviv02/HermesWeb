package com.hermes.core.infrastructure.dataaccess.specifications.places;

import com.hermes.core.domain.places.AbstractPlace;
import com.hermes.core.infrastructure.dataaccess.specifications.AbstractSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * Created by ivan on 09.11.16.
 */
public class HasName extends AbstractSpecification<AbstractPlace>{
    private String name;

    HasName(String name) {
        this.name = name;
    }

    public boolean isSatisfiedBy(AbstractPlace place) {
        return place.getName() == this.name;
    }

    public Criterion toCriterion() {
        return Restrictions.eq("name", this.name);
    }
}
