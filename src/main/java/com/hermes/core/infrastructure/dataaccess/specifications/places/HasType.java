package com.hermes.core.infrastructure.dataaccess.specifications.places;

import com.hermes.core.domain.places.AbstractPlace;
import com.hermes.core.infrastructure.dataaccess.specifications.AbstractSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * Created by ivan on 02.11.16.
 */
public class HasType extends AbstractSpecification<AbstractPlace> {

    private Class specifiedClass;

    public HasType(Class specifiedClass) {
        this.specifiedClass = specifiedClass;
    }

    public boolean isSatisfiedBy(AbstractPlace place) {
//        return place instanceof specifiedClass;
        return true;
    }

    public Criterion toCriterion() {
        return Restrictions.eq("class", specifiedClass);
    }
}
