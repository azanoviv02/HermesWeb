package com.hermes.hermes.domain.milestones;

import com.hermes.hermes.domain.places.AbstractBase;
import com.hermes.hermes.domain.places.AbstractPlace;

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

    public AbstractPlace getPlace(){
        return finishBase;
    }

    public FinishMilestone() {
    }

    public FinishMilestone(Calendar date, AbstractBase finishBase) {
        super(date);
        this.finishBase = finishBase;
    }
}
