package com.hermes.core.domain.milestones;

import com.hermes.core.domain.places.AbstractBase;

import java.util.Calendar;

/**
 * Created by ivan on 14.11.16.
 */
public interface MilestoneFactory {
    StartMilestone createStartMilestone(Calendar date, AbstractBase startBase);

    FinishMilestone createFinishMilestone(Calendar date, AbstractBase finishBase);
}
