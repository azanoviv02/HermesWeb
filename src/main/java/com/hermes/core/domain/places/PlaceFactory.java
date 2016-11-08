package com.hermes.core.domain.places;

/**
 * Created by ivan on 02.11.16.
 */
public interface PlaceFactory {
    BasicCompanyBase createBasicCompanyBase(String name);

    BasicClientBase createBasicClientBase(String name);

    BasicFix createBasicFix(String name);
}
