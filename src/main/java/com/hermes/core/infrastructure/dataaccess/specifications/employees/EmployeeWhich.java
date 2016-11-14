package com.hermes.core.infrastructure.dataaccess.specifications.employees;

import com.hermes.core.domain.employees.AbstractEmployee;
import com.hermes.core.infrastructure.dataaccess.specifications.AbstractWhich;
import org.springframework.stereotype.Component;

/**
 * Created by ivan on 09.11.16.
 */
@Component
public class EmployeeWhich extends AbstractWhich<AbstractEmployee> {
    public EmployeeWhich() {
    }

    public IsDriver isDriver(){
        return new IsDriver();
    }
}

