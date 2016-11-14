package com.hermes.core.domain.milestones;

import com.hermes.core.domain.places.AbstractPlace;

import java.util.Date;

/**
 * Created by ivan on 14.11.16.
 */
public interface MilestoneFactory {
    StartMilestone createStartMilestone(Date date, AbstractPlace startPlace);

    FinishMilestone createFinishMilestone(Date date, AbstractPlace finishPlace);
}
