package com.hermes.core.infrastructure.dataaccess.specifications.places;

import com.hermes.core.domain.places.AbstractPlace;
import com.hermes.core.infrastructure.dataaccess.specifications.AbstractWhich;
import org.springframework.stereotype.Component;

/**
 * Created by ivan on 09.11.16.
 */
@Component
public class PlaceWhich extends AbstractWhich<AbstractPlace>{
    public PlaceWhich() {
    }

    public HasName hasName(String name){
        return new HasName(name);
    }
}
