package com.hermes.core.domain.orders;

import com.hermes.core.domain.AbstractPersistentObject;
import com.hermes.core.domain.cargo.AbstractCargo;
import com.hermes.core.domain.places.AbstractPlace;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
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

    @Temporal(TemporalType.DATE)
    @Column(name="START_DATE", nullable = false)
    Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name="FINISH_DATE", nullable = false)
    Date finishDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "START_PLACE_ID")
//    @Cascade({CascadeType.SAVE_UPDATE})
    AbstractPlace startPlace;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FINISH_PLACE_ID")
//    @Cascade({CascadeType.SAVE_UPDATE})
    AbstractPlace finishPlace;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    @Cascade({CascadeType.SAVE_UPDATE})
    List<AbstractCargo> cargoList;

    AbstractOrder() {
        this.cargoList = new ArrayList<>();
    }

    public String getClientName() {
        return clientName;
    }

    void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Date getStartDate() {
        return startDate;
    }

    void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public AbstractPlace getStartPlace() {
        return startPlace;
    }

    void setStartPlace(AbstractPlace startPlace) {
        this.startPlace = startPlace;
    }

    public AbstractPlace getFinishPlace() {
        return finishPlace;
    }

    void setFinishPlace(AbstractPlace finishPlace) {
        this.finishPlace = finishPlace;
    }

    public int getSize() {
        return cargoList.size();
    }

    public List<AbstractCargo> getCargoList() {
        List<AbstractCargo> detachedList = new ArrayList<>(cargoList.size());
        detachedList.addAll(cargoList);
        return detachedList;
    }

    void addCargo(AbstractCargo cargo){
        cargo.setOrder(this);
        cargoList.add(cargo);
    }

    public int size(){
        return cargoList.size();
    }
}
