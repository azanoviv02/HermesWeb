package com.hermes.core.domain.places;


import com.hermes.core.domain.milestones.FinishMilestone;
import com.hermes.core.domain.milestones.StartMilestone;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by ivan on 26.10.16.
 */
@Entity
@DiscriminatorValue("ABSTRACT_BASE")
public abstract class AbstractBase extends AbstractPlace {

    @OneToMany(mappedBy = "startPlace")
    protected List<StartMilestone> milestonesFrom;

    @OneToMany(mappedBy = "finishPlace")
    protected List<FinishMilestone> milestonesTo;

    AbstractBase() {
    }

    AbstractBase(String name) {
        super(name);
    }

    public List<StartMilestone> getMilestonesFrom() {
        return milestonesFrom;
    }

    public List<FinishMilestone> getMilestonesTo() {
        return milestonesTo;
    }
}
