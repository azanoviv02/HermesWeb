package com.hermes.core.domain.milestones;

import com.hermes.core.domain.places.AbstractPlace;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by ivan on 14.11.16.
 */
@Component
public class MilestoneFactoryImpl implements MilestoneFactory {

    public MilestoneFactoryImpl() {
    }

    @Override
    public StartMilestone createStartMilestone(Date date, AbstractPlace startPlace){
        return new StartMilestone(date, startPlace);
    }

    @Override
    public FinishMilestone createFinishMilestone(Date date, AbstractPlace finishPlace){
        return new FinishMilestone(date, finishPlace);
    }
}
