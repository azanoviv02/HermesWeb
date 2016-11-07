package com.hermes.hermes.infrastructure.dataaccess.services;


import com.hermes.hermes.domain.employees.AbstractEmployee;

/**
 * Created by ivan on 05.11.16.
 */
public class EmployeeServiceImpl extends GenericServiceImpl<AbstractEmployee> implements EmployeeService {
    public EmployeeServiceImpl(GenericRepository<AbstractEmployee> repository) {
        super(repository);
    }
}

