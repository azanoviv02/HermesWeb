package com.hermes.hermes.infrastructure.dataaccess.services;


import com.hermes.hermes.domain.employees.AbstractEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ivan on 05.11.16.
 */
@Service
public class EmployeeServiceImpl extends GenericServiceImpl<AbstractEmployee> implements EmployeeService {

    @Autowired
    public EmployeeServiceImpl(GenericRepository<AbstractEmployee> repository) {
        super(repository);
    }
}

