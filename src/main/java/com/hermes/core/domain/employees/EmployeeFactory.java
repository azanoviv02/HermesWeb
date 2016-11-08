package com.hermes.core.domain.employees;

/**
 * Created by ivan on 05.11.16.
 */
public interface EmployeeFactory {
    BasicDriver createBasicDriver(String name);

    BasicDriver createBasicDriver(String name, int salary);
}
