package com.hermes.core.domain.milestones;


import com.hermes.core.domain.AbstractPersistentObject;
import com.hermes.core.domain.hauls.AbstractHaul;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by ivan on 26.10.16.
 */
@Entity
@Table(name="MILESTONES")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="ENTITY_TYPE", discriminatorType=DiscriminatorType.STRING, length = 20)
@DiscriminatorValue("ABSTRACT_MILESTONE")
public abstract class AbstractMilestone extends AbstractPersistentObject {

    @OneToOne(cascade = CascadeType.PERSIST , fetch = FetchType.EAGER)
    @JoinColumn(name = "HAUL_ID", referencedColumnName = "ID")
    protected AbstractHaul haul;

    @Temporal(TemporalType.DATE)
    @Column(name="DATE", nullable = false)
    private Calendar date;

    AbstractMilestone() {
    }

    AbstractMilestone(Calendar date) {
        this.date = date;
    }

    public Calendar getDate() {
        return date;
    }
    
    public AbstractHaul getHaul() {
        return haul;
    }

    public void setHaul(AbstractHaul haul) {
        this.haul = haul;
    }
}
