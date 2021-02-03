package com.example.demo.domain.models.user;

import com.example.demo.domain.exceptions.ArgumentNullException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserIdTest {

    @Test
    @DisplayName("Expect to throw Exception when Argument is null")
    void whenArgumentIsNull_throwException() throws Exception {

        // Act & Assert
        assertThrows(
                ArgumentNullException.class,
                () -> new UserId(null));
    }

    @Test
    @DisplayName("Expect to get UserId when UserId exists")
    void whenUserIdExists_expectToGetUserId() {

        // Arrange
        UserId userId = new UserId("12345");

        // Act & Assert
        assertEquals("12345", userId.getValue());
    }

    @Test
    @DisplayName("Expect to get correct hashCode")
    void whenUserIdExists_expectToGetCorrectHashCode() {

        // Arrange
        UserId userId_1 = new UserId("12345");
        UserId userId_2 = new UserId("12345");

        // Act & Assert
        assertNotNull(userId_1.hashCode());
        assertNotEquals(userId_2, userId_1);
    }

    @Test
    @DisplayName("Expect to return true when object has same value")
    void whenObjectHasSameValue_expectToReturnTrue() {

        // Arrange
        UserId userId_1 = new UserId("12345");
        UserId userId_2 = new UserId("12345");

        // Act & Assert
        assertTrue(userId_1.hasSameValueAs(userId_2));
    }

    @Test
    @DisplayName("Expect to return false when object has different value")
    void whenObjectHasDifferentValue_expectToReturnFalse() {

        // Arrange
        UserId userId_1 = new UserId("12345");
        UserId userId_2 = new UserId("123456");

        // Act & Assert
        assertFalse(userId_1.hasSameValueAs(userId_2));
    }
}
