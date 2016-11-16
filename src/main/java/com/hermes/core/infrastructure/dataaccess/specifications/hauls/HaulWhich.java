package com.hermes.core.infrastructure.dataaccess.specifications.hauls;

import com.hermes.core.domain.hauls.AbstractHaul;
import com.hermes.core.domain.hauls.HaulStatus;
import com.hermes.core.infrastructure.dataaccess.specifications.AbstractWhich;
import org.springframework.stereotype.Component;

/**
 * Created by ivan on 09.11.16.
 */
@Component
public class HaulWhich extends AbstractWhich<AbstractHaul> {
    public HaulWhich() {
    }

    public HasStatus hasStatus(HaulStatus haulStatus){
        return new HasStatus(haulStatus);
    }

    public HasStatus isCreated(){
        return new HasStatus(HaulStatus.CREATED);
    }

    public HasStatus isUnderway(){
        return new HasStatus(HaulStatus.UNDERWAY);
    }

    public HasStatus isDelayed(){
        return new HasStatus(HaulStatus.DELAYED);
    }

    public HasStatus isFinished(){
        return new HasStatus(HaulStatus.FINISHED);
    }
}


