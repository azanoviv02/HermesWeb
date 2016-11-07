package com.hermes.hermes.infrastructure.dataaccess.services;

import com.hermes.hermes.domain.milestones.AbstractMilestone;

public class MilestoneServiceImpl extends GenericServiceImpl<AbstractMilestone> implements MilestoneService {
    public MilestoneServiceImpl(GenericRepository<AbstractMilestone> repository) {
        super(repository);
    }
}
