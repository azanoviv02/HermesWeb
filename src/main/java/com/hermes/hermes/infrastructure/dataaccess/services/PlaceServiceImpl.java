package com.hermes.hermes.infrastructure.dataaccess.services;

import com.hermes.hermes.domain.places.AbstractPlace;

/**
 * Created by ivan on 05.11.16.
 */
public class PlaceServiceImpl extends GenericServiceImpl<AbstractPlace> implements PlaceService {
    public PlaceServiceImpl(GenericRepository<AbstractPlace> repository) {
        super(repository);
    }
}
