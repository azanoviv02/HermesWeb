package com.hermes.core.domain.cargo;


import com.hermes.core.domain.AbstractPersistentObject;
import com.hermes.core.domain.hauls.AbstractHaul;
import com.hermes.core.domain.orders.AbstractOrder;

import javax.persistence.*;

/**
 * Created by ivan on 26.10.16.
 */
@Entity
@Table(name = "CARGO")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="ENTITY_TYPE", discriminatorType=DiscriminatorType.STRING, length = 20)
@DiscriminatorValue("ABSTRACT_CARGO")
public abstract class AbstractCargo extends AbstractPersistentObject {

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ORDER_ID", referencedColumnName = "ID")
//    @Cascade({CascadeType.SAVE_UPDATE})
    protected AbstractOrder order;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="HAUL_ID", referencedColumnName = "ID")
    protected AbstractHaul haul;

    @Column(name="WEIGHT", nullable = false)
    protected double weight;

    @Column(name="VOLUME", nullable = false)
    protected double volume;

    AbstractCargo() {
    }

    public AbstractCargo(double weight, double volume) {
        this.weight = weight;
        this.volume = volume;
    }

    public AbstractCargo(AbstractOrder order, double weight, double volume) {
        this.order = order;
        this.weight = weight;
        this.volume = volume;
    }

    public AbstractOrder getOrder() {
        return order;
    }

    public void setOrder(AbstractOrder order) {
        this.order = order;
    }

    public String getCargoType(){
        if(this instanceof Box){
            return "Box";
        }else{
            throw new IllegalStateException();
        }
    }

    public AbstractHaul getHaul() {
        return haul;
    }

    public void setHaul(AbstractHaul haul) {
        this.haul = haul;
    }

    public double getWeight() {
        return weight;
    }

    public double getVolume() {
        return volume;
    }
}

