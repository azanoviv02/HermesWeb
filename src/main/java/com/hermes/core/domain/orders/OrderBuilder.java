package com.hermes.core.domain.orders;


import com.hermes.core.domain.cargo.CargoFactory;
import com.hermes.core.domain.cargo.CargoType;

/**
 * Created by ivan on 02.11.16.
 */
public class OrderBuilder {

    private AbstractOrder order;
    private CargoFactory cargoFactory;

    public OrderBuilder(CargoFactory cargoFactory) {
        this.cargoFactory = cargoFactory;
        this.order = new BasicOrder();
        this.cargoFactory.setOrder(this.order);
    }

    public void setClientName(String clientName) {
        order.setClientName(clientName);
    }

    public void addCargo(CargoType cargoType, double weight, double volume){
        order.addCargo(cargoFactory.createCargo(cargoType, weight, volume));
    }

    public void addCargo(CargoType cargoType, double weight, double volume, int amount){
        for(int i = 0; i < amount; i++){
            addCargo(cargoType, weight, volume);
        }
    }

    public boolean orderIsReady(){
        return (order.getClientName() != null) && (order.size() > 0);
    }
    public AbstractOrder getOrder(){
        if(orderIsReady()){
            return order;
        }else{
            throw new IllegalStateException();
        }
    }
}
