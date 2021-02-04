package com.example.demo.domain.models.user;

import com.example.demo.domain.exceptions.ArgumentNullException;
import com.example.demo.domain.patterninterfaces.Entity;

/**
 * User class.
 *
 */
public class User implements Entity<User> {

    private UserId id;
    private UserName name;

    /**
     * User constructor.
     *
     * @param id
     * @param name
     */
    public User(UserId id, UserName name) {

        this.id = id;
        this.name = name;
    }

    /**
     * Get UserId Value Object.
     *
     * @return id UserId
     */
    public UserId getId() {
        return this.id;
    }

    /**
     * Get UserName Value Object.
     *
     * @return name UserName
     */
    public UserName getName() {
        return this.name;
    }

    /**
     * Change User Name.
     *
     * @param name
     * @return void
     */
    public void changeUserName(String name) {

        if ( name == null ) throw new ArgumentNullException("");
        if ( name.length() < 3 ) throw new IllegalArgumentException("ユーザ名は3文字以上です. ");

        this.name = new UserName(name);
    }

    @Override
    public boolean hasSameIdentityAs(final User other) {
        return other != null && this.id.hasSameValueAs(other.id);
    }

    @Override
    public boolean equals(final Object object) {

        if ( this == object ) return true;
        if ( object == null || getClass() != object.getClass()) return false;

        final User other = (User) object;
        return hasSameIdentityAs(other);
    }
}
