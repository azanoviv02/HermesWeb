package com.hermes.hermes.infrastructure.dataaccess.services;

import com.hermes.hermes.domain.places.AbstractPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ivan on 05.11.16.
 */
@Service
public class PlaceServiceImpl extends GenericServiceImpl<AbstractPlace> implements PlaceService {

    @Autowired
    public PlaceServiceImpl(GenericRepository<AbstractPlace> repository) {
        super(repository);
    }
}
