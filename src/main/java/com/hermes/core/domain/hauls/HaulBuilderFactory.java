package com.hermes.core.domain.hauls;

import com.hermes.core.infrastructure.dataaccess.services.HaulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ivan on 14.11.16.
 */
@Component
public class HaulBuilderFactory {

    @Autowired
    HaulService haulService;

    public HaulBuilder createHaulBuilder(){
        return new HaulBuilder(haulService);
    }
}
