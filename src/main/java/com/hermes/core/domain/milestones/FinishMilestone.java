package com.hermes.core.domain.milestones;

import com.hermes.core.domain.places.AbstractPlace;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ivan on 31.10.16.
 */
@Entity
@DiscriminatorValue("FINISH_MILESTONE")
public class FinishMilestone extends AbstractMilestone {

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="PLACE_ID", referencedColumnName = "ID")
    private AbstractPlace finishPlace;

    private FinishMilestone() {
    }

    FinishMilestone(Date date, AbstractPlace finishPlace) {
        super(date);
        this.finishPlace = finishPlace;
    }

    public AbstractPlace getPlace(){
        return finishPlace;
    }
}
