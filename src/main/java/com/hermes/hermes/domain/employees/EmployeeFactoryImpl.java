package com.hermes.hermes.domain.employees;

import org.springframework.stereotype.Component;

/**
 * Created by ivan on 02.11.16.
 */
@Component
public class EmployeeFactoryImpl implements EmployeeFactory {

    public EmployeeFactoryImpl() {
    }

    @Override
    public BasicDriver createBasicDriver(String name){
        return new BasicDriver(name);
    }

    @Override
    public BasicDriver createBasicDriver(String name, int salary){
        return new BasicDriver(name, salary);
    }
}
