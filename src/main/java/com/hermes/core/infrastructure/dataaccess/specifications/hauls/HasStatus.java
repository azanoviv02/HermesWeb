package com.hermes.core.infrastructure.dataaccess.specifications.hauls;

import com.hermes.core.domain.hauls.AbstractHaul;
import com.hermes.core.domain.hauls.HaulStatus;
import com.hermes.core.infrastructure.dataaccess.specifications.AbstractSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * Created by ivan on 02.11.16.
 */
public class HasStatus extends AbstractSpecification<AbstractHaul> {

    private final HaulStatus haulStatus;

    public HasStatus(HaulStatus haulStatus) {
        this.haulStatus = haulStatus;
    }

    public boolean isSatisfiedBy(AbstractHaul haul) {
        return haul.getHaulStatus() == this.haulStatus;
    }

    public Criterion toCriterion() {
        return Restrictions.eq("haulStatus", this.haulStatus);
    }
}
