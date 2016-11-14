package com.hermes.core.domain.milestones;

import com.hermes.core.domain.places.AbstractBase;
import com.hermes.core.domain.places.AbstractPlace;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by ivan on 31.10.16.
 */
@Entity
@DiscriminatorValue("FINISH_MILESTONE")
public class FinishMilestone extends AbstractMilestone {

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="PLACE_ID", referencedColumnName = "ID")
    private AbstractBase finishBase;

    FinishMilestone() {
    }

    FinishMilestone(Calendar date, AbstractBase finishBase) {
        super(date);
        this.finishBase = finishBase;
    }

    public AbstractPlace getPlace(){
        return finishBase;
    }
}
