package com.example.demo.domain.models.user;

import com.example.demo.domain.exceptions.ArgumentNullException;
import com.example.demo.domain.patterninterfaces.ValueObject;

/**
 *
 */
public class UserName implements ValueObject<UserName> {

    /** */
    private final String value;

    /**
     * UserName constructor.
     *
     * @param value
     */
    public UserName(final String value) {

       if ( value == null ) throw new ArgumentNullException("Value can't be null");
       if ( value.length() < 3 ) throw new IllegalArgumentException("User Name needs 3 characters or more");

       this.value = value;
    }

    /**
     * Get UserName.
     *
     * @return
     */
    public String getValue() {
        return this.value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean hasSameValueAs(UserName other) {
        return other != null && this.value.equals(other.value);
    }
}
