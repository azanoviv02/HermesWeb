package com.hermes.core.domain.places;


import com.hermes.core.domain.AbstractPersistentObject;

import javax.persistence.*;

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

    public String getPlaceType(){
        if(this instanceof BasicCompanyBase){
            return "Company base";
        }
        if(this instanceof BasicClientBase){
            return "Client base";
        }
        if(this instanceof BasicFix){
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
