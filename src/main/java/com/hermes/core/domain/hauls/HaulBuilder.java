package com.hermes.core.domain.hauls;

/**
 * Created by ivan on 02.11.16.
 */
public class HaulBuilder {

    private HaulBuilder() {
    }

    public static HaulBuilder newHaulBuilder(){
        return new HaulBuilder();
    }
}
