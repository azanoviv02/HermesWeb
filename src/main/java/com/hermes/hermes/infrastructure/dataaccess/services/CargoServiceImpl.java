package com.hermes.hermes.infrastructure.dataaccess.services;

import com.hermes.hermes.domain.cargo.AbstractCargo;

/**
 * Created by ivan on 05.11.16.
 */
public class CargoServiceImpl extends GenericServiceImpl<AbstractCargo> implements CargoService {
    public CargoServiceImpl(GenericRepository<AbstractCargo> repository) {
        super(repository);
    }
}
