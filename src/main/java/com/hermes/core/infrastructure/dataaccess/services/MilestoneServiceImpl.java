package com.hermes.core.infrastructure.dataaccess.services;

import com.hermes.core.domain.milestones.AbstractMilestone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MilestoneServiceImpl extends GenericServiceImpl<AbstractMilestone> implements MilestoneService {

    @Autowired
    public MilestoneServiceImpl(GenericRepository<AbstractMilestone> repository) {
        super(repository);
    }
}
