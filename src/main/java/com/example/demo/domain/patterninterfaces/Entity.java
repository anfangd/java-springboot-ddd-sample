package com.example.demo.domain.patterninterfaces;

/**
 * An Entity, as described in the Domain-Driven Design Book written by Eric Evans.
 *
 * @param <T>
 */
public interface Entity<T> {

    /**
     * Entities compare by identity, not by attributes.
     *
     * @param other The other entity.
     * @return <code>true</code> if the identities are the same, regardless of other attributes.
     */
    boolean hasSameIdentityAs(T other);

    /**
     * Return this Object's hashCode.
     *
     * @return hashCode
     */
    int hashCode();
}
