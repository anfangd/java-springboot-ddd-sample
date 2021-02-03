package com.example.demo.domain.models.user;

import com.example.demo.domain.patterninterfaces.ValueObject;
import com.example.demo.domain.exceptions.ArgumentNullException;

/**
 *
 */
public class UserId implements ValueObject<UserId> {

    /**  */
    private final String value;

    /**
     * UserId constructor.
     *
     * @param value
     */
    public UserId(String value) {

        if ( value == null ) {
            throw new ArgumentNullException("");
        }
        this.value = value;
    }

    /**
     * Get UerId.
     *
     * @return value
     */
    public String getValue() {

        return this.value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean hasSameValueAs(UserId other) {
        return other != null && this.value.equals(other.value);
    }
}
