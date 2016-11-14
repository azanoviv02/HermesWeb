package com.hermes.core.domain.milestones;


import com.hermes.core.domain.AbstractPersistentObject;
import com.hermes.core.domain.hauls.AbstractHaul;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ivan on 26.10.16.
 */
@Entity
@Table(name="MILESTONES")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="ENTITY_TYPE", discriminatorType=DiscriminatorType.STRING, length = 20)
@DiscriminatorValue("ABSTRACT_MILESTONE")
public abstract class AbstractMilestone extends AbstractPersistentObject {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "HAUL_ID", referencedColumnName = "ID")
    protected AbstractHaul haul;

    @Temporal(TemporalType.DATE)
    @Column(name="DATE", nullable = false)
//    @Cascade({CascadeType.ALL})
    private Date date;

    AbstractMilestone() {
    }

    AbstractMilestone(Date date) {
        if(date == null){
            System.out.println("No date!");
        }
        System.out.println(date.toString());
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
    
    public AbstractHaul getHaul() {
        return haul;
    }

    public void setHaul(AbstractHaul haul) {
        this.haul = haul;
    }
}
