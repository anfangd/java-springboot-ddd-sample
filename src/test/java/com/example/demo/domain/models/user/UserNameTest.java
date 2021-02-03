package com.example.demo.domain.models.user;

import com.example.demo.domain.exceptions.ArgumentNullException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserNameTest {

    @Test
    @DisplayName("ユーザ名が nll の時に例外を投げる")
    void whenUserNameIsNull_throwException() {

        // Act & Assert
        assertThrows(
                ArgumentNullException.class,
                () -> new UserName(null)
        );
    }

    @Test
    @DisplayName("ユーザ名が 3文字より少ないときに例外を投げる")
    void whenUserNameIsLessThan3Characters_throwException() {

        // Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> new UserName("12")
        );
    }

    @Test
    @DisplayName("値を取得できる")
    void expectToGetValue() {

        // Arrange
        UserName userName = new UserName("abc");

        // Act & Assert
        assertEquals("abc",userName.getValue());
    }

    @Test
    @DisplayName("hashCode を取得できる")
    void expectToGetHashCode() {

        // Arrange
        UserName userName_1 = new UserName("abc");
        UserName userName_2 = new UserName("abc");

        // Act & Assert
        assertNotNull(userName_1.hashCode());
        assertNotEquals(userName_2, userName_1);
    }

    @Test
    @DisplayName("同じ値を持つインスタンスを比較した場合、trueが返る")
    void whenComparedWithSameValues_expectToReturnTrue() {

        // Arrange
        UserName userName_1 = new UserName("abc");
        UserName userName_2 = new UserName("abc");

        // Assert
        assertTrue(userName_1.hasSameValueAs(userName_2));
    }

    @Test
    @DisplayName("異なる値を持つインスタンスを比較した場合、falseが返る")
    void whenComparedWithDifferentValues_expectToReturnFalse() {

        // Arrange
        UserName userName_1 = new UserName("abc");
        UserName userName_2 = new UserName("abcd");

        // Assert
        assertFalse(userName_1.hasSameValueAs(userName_2));
    }
}
