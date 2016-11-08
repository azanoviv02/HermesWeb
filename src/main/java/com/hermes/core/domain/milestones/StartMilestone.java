package com.hermes.core.domain.milestones;

import com.hermes.core.domain.places.AbstractBase;
import com.hermes.core.domain.places.AbstractPlace;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by ivan on 31.10.16.
 */
@Entity
@DiscriminatorValue("START_MILESTONE")
public class StartMilestone extends AbstractMilestone {

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="PLACE_ID", referencedColumnName = "ID")
    private AbstractBase startBase;

    public AbstractPlace getPlace(){
        return startBase;
    }

    StartMilestone() {
    }

    public StartMilestone(Calendar date, AbstractBase startBase) {
        super(date);
        this.startBase = startBase;
    }
}
