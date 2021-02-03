package com.example.demo.domain.patterninterfaces;

import java.io.Serializable;

/**
 * A value object, as described in the Domain-Driven Design Book written by Eric Evans.
 *
 * @param <T>
 */
public interface ValueObject<T> extends Serializable {

    /**
     * Value objects compare by the values of their attributes, they don't have an identity.
     *
     * @param other The other value object.
     * @return <code>true</code> if the given value object's and this value object's attributes are the same.
     */
    boolean hasSameValueAs(T other);

    /**
     * Return this Object's hashCode.
     *
     * @return hashCode
     */
    int hashCode();
}
