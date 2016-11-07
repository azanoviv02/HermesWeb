package com.hermes.hermes.domain.places;

import org.springframework.stereotype.Component;

/**
 * Created by ivan on 02.11.16.
 */
@Component
public class PlaceFactoryImpl implements PlaceFactory {

    public PlaceFactoryImpl() {
    }

    @Override
    public BasicCompanyBase createBasicCompanyBase(String name){
        return new BasicCompanyBase(name);
    }

    @Override
    public BasicClientBase createBasicClientBase(String name){
        return new BasicClientBase(name);
    }

    @Override
    public BasicFix createBasicFix(String name){
        return new BasicFix(name);
    }
}
