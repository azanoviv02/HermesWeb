package com.hermes.core.infrastructure.dataaccess.services;

import com.hermes.core.domain.cargo.AbstractCargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ivan on 05.11.16.
 */
@Service
public class CargoServiceImpl extends GenericServiceImpl<AbstractCargo> implements CargoService {

    @Autowired
    public CargoServiceImpl(GenericRepository<AbstractCargo> repository) {
        super(repository);
    }
}
