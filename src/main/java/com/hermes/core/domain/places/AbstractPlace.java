package com.hermes.core.domain.places;


import com.hermes.core.domain.AbstractPersistentObject;
import com.hermes.core.domain.hauls.AbstractHaul;
import com.hermes.core.domain.orders.AbstractOrder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="PLACES")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="ENTITY_TYPE", discriminatorType=DiscriminatorType.STRING, length = 20)
@DiscriminatorValue("ABSTRACT_PLACE")
public abstract class AbstractPlace extends AbstractPersistentObject {

    @Column(name="NAME")
    private String name;

    public String getName() {
        return name;
    }

    @OneToMany(mappedBy = "startPlace", fetch = FetchType.LAZY)
//    @Cascade({CascadeType.SAVE_UPDATE})
    List<AbstractHaul> haulsFrom;

    @OneToMany(mappedBy = "finishPlace", fetch = FetchType.LAZY)
//    @Cascade({CascadeType.SAVE_UPDATE})
    List<AbstractHaul> haulsTo;

    @OneToMany(mappedBy = "startPlace", fetch = FetchType.LAZY)
//    @Cascade({CascadeType.SAVE_UPDATE})
    List<AbstractOrder> ordersFrom;

    @OneToMany(mappedBy = "startPlace", fetch = FetchType.LAZY)
//    @Cascade({CascadeType.SAVE_UPDATE})
    List<AbstractOrder> ordersTo;

    public String getPlaceType(){
        if(this instanceof BasicCompanyBase){
            return "Company base";
        }else if(this instanceof BasicClientBase){
            return "Client base";
        }else if(this instanceof BasicFix){
            return "Fix";
        }
        throw new IllegalStateException();
    }

    AbstractPlace() {
    }

    AbstractPlace(String name) {
        this.name = name;
    }
}
