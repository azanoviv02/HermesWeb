package com.hermes.core.domain.milestones;

import com.hermes.core.domain.places.AbstractBase;
import org.springframework.stereotype.Component;

import java.util.Calendar;

/**
 * Created by ivan on 14.11.16.
 */
@Component
public class MilestoneFactoryImpl implements MilestoneFactory {

    public MilestoneFactoryImpl() {
    }

    @Override
    public StartMilestone createStartMilestone(Calendar date, AbstractBase startBase){
        return new StartMilestone(date, startBase);
    }

    @Override
    public FinishMilestone createFinishMilestone(Calendar date, AbstractBase finishBase){
        return new FinishMilestone(date, finishBase);
    }
}
