package com.hermes.core.domain.places;

/**
 * Created by ivan on 09.11.16.
 */
public class PlaceNameAlreadyExistsException extends Exception{
    public PlaceNameAlreadyExistsException() {
    }

    public PlaceNameAlreadyExistsException(String message) {
        super(message);
    }

    public PlaceNameAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlaceNameAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public PlaceNameAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
