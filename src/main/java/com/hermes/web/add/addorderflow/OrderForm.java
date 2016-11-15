package com.hermes.web.add.addorderflow;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ivan on 11.11.16.
 */
public class OrderForm implements Serializable {

    private String clientName;

    private Set<CargoForm> allСargoForms;

    OrderForm() {
        allСargoForms = new HashSet<>();
    }

    static OrderForm createOrderForm(){
        return new OrderForm();
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public CargoForm newCargoForm(){
        CargoForm cargoForm= new CargoForm();
        allСargoForms.add(cargoForm);
        return cargoForm;
    }

    public Set<CargoForm> getAllСargoForms() {
        return allСargoForms;
    }
}
