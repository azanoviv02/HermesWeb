package com.hermes.core.domain.orders;

import com.hermes.core.domain.AbstractPersistentObject;
import com.hermes.core.domain.cargo.AbstractCargo;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan on 26.10.16.
 */
@Entity
@Table(name="ORDERS")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="ENTITY_TYPE", discriminatorType=DiscriminatorType.STRING, length = 20)
@DiscriminatorValue("ABSTRACT_ORDER")
public abstract class AbstractOrder extends AbstractPersistentObject {

    @Column(name="CLIENT_NAME", nullable = false)
    String clientName;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    @Cascade({CascadeType.ALL})
    List<AbstractCargo> cargoList;

    AbstractOrder() {
        this.cargoList = new ArrayList<>();
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getSize() {
        return cargoList.size();
    }

//    public void setSize(int size) {
//        this.size = size;
//    }

    public List<AbstractCargo> getCargoList() {
        List<AbstractCargo> detachedList = new ArrayList<>(cargoList.size());
        detachedList.addAll(cargoList);
        return detachedList;
    }

    void addCargo(AbstractCargo cargo){
        cargoList.add(cargo);
    }

    public int size(){
        return cargoList.size();
    }
}
