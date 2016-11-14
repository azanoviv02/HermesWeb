package com.hermes.core.domain.milestones;

import com.hermes.core.domain.places.AbstractPlace;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ivan on 31.10.16.
 */
@Entity
@DiscriminatorValue("START_MILESTONE")
public class StartMilestone extends AbstractMilestone {

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="PLACE_ID", referencedColumnName = "ID")
    private AbstractPlace startPlace;

    private StartMilestone() {
    }

    StartMilestone(Date date, AbstractPlace startPlace) {
        super(date);
        this.startPlace = startPlace;
    }

    public AbstractPlace getPlace(){
        return startPlace;
    }
}
