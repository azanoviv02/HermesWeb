package com.hermes.hermes.infrastructure.dataaccess.services;


import com.hermes.hermes.domain.hauls.AbstractHaul;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ivan on 05.11.16.
 */
@Service
public class HaulServiceImpl extends GenericServiceImpl<AbstractHaul> implements HaulService {

    @Autowired
    public HaulServiceImpl(GenericRepository<AbstractHaul> repository) {
        super(repository);
    }
}
