package com.hermes.core.domain.cargo;

import com.hermes.core.domain.orders.AbstractOrder;
import org.springframework.stereotype.Component;

/**
 * Created by ivan on 02.11.16.
 */
@Component
public class CargoFactoryImpl implements CargoFactory{

    static private final double DELTA = 0.00001;

    private AbstractOrder order;

    public CargoFactoryImpl() {
    }

    @Override
    public void setOrder(AbstractOrder order) {
        this.order = order;
    }

    @Override
    public AbstractCargo createCargo(CargoType cargoType, double weight, double volume){
        if(order == null){
            throw new IllegalStateException();
        }
        AbstractCargo cargo = null;
        if(isZero(weight) || isZero(volume)){
            throw new IllegalArgumentException("Improbable cargo measurments");
        }
        switch (cargoType){
            case BOX:
                cargo = new Box(order, weight, volume);
                break;
            case BARREL:
                cargo = new Barrel(order, weight, volume);
                break;
            default:
                throw new IllegalArgumentException("Incorrect cargo type");
        }
        cargo.setOrder(order);
        return cargo;
    }

    public boolean isZero(double value){
        return (Math.abs(value) < DELTA);
    }
}
