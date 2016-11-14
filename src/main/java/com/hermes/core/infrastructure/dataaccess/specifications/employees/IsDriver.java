package com.hermes.core.infrastructure.dataaccess.specifications.employees;

import com.hermes.core.domain.employees.AbstractEmployee;
import com.hermes.core.domain.employees.BasicDriver;
import com.hermes.core.infrastructure.dataaccess.specifications.AbstractSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * Created by ivan on 02.11.16.
 */
public class IsDriver extends AbstractSpecification<AbstractEmployee> {

    IsDriver() {
    }

    public boolean isSatisfiedBy(AbstractEmployee employee) {
        return (employee instanceof BasicDriver);
    }

    public Criterion toCriterion() {
        return Restrictions.eq("class", BasicDriver.class);
    }
}
