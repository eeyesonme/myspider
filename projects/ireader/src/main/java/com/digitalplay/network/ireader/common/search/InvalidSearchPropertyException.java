package com.digitalplay.network.ireader.common.search;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-1-17 上午11:44
 * <p>Version: 1.0
 */
public final class InvalidSearchPropertyException extends SearchException {

    public InvalidSearchPropertyException(String searchProperty, String entityProperty) {
        this(searchProperty, entityProperty, null);
    }

    public InvalidSearchPropertyException(String searchProperty, String entityProperty, Throwable cause) {
        super("Invalid Search Property [" + searchProperty + "] Entity Property [" + entityProperty + "]", cause);
    }


}
