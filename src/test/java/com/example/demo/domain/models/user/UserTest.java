package com.example.demo.domain.models.user;

import com.example.demo.domain.exceptions.ArgumentNullException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    @DisplayName("引数が null の時に Exception を返す")
    void whenArgumentIsNull_expectToReturnException() {

        // Arrange
        User user = new User(new UserId("123"), new UserName("abc"));

        // Act & Assert
        assertThrows(
                ArgumentNullException.class,
                () -> user.changeUserName(null)
        );
    }

    @Test
    @DisplayName("ユーザ名の変更時、引数が 3文字より少ない時に Exception を返す")
    void whenArgumentIsLessThan3Characters_expectToReturnException() {

        // Arrange
        User user = new User(new UserId("123"), new UserName("abc"));

        // Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> user.changeUserName("12")
        );
    }

    @Test
    @DisplayName("ユーザ名を変更することが出来る")
    void expectToChangeUserName() {

        // Arrange
        User user = new User(new UserId("123"), new UserName("abc"));

        // Act
        user.changeUserName("def");

        // Assert
        assertEquals(user.getName().getValue(), "def");
    }

    @Test
    @DisplayName("同じ値を持つ時に true を返す")
    void whenInstanceHasSameValue_expectToReturnTrue() {

        // Arrange
        User user_1 = new User(new UserId("123"), new UserName("abc"));
        User user_2 = new User(new UserId("123"), new UserName("abc"));

        // Act & Assert
        assertTrue(user_1.hasSameIdentityAs(user_2));
    }

    @Test
    @DisplayName("異なる値を持つ時に false を返す")
    void whenInstanceHasDifferentValue_expectToReturnFalse() {

        // Arrange
        User user_1 = new User(new UserId("123"), new UserName("abc"));
        User user_2 = new User(new UserId("1234"), new UserName("abc"));

        // Act & Assert
        assertFalse(user_1.hasSameIdentityAs(user_2));
    }

    @Test
    @DisplayName("同一のときに true を返す")
    void whenInstanceIsSame_expectToReturnTrue() {

        // Arrange
        User user_1 = new User(new UserId("123"), new UserName("abc"));

        // Act & Assert
        assertTrue(user_1.equals(user_1));
    }

    @Test
    @DisplayName("異なるときに false を返す")
    void whenInstanceIsDifferent_expectToReturnFalse() {

        // Arrange
        User user_1 = new User(new UserId("123"), new UserName("abc"));
        User user_2 = new User(new UserId("1234"), new UserName("abc"));

        // Act & Assert
        assertFalse(user_1.equals(user_2));
    }

    @Test
    @DisplayName("UserId を取得出来る")
    void expectToGetUserId() {

        // Arrange
        UserId userId = new UserId("123");
        User user = new User(userId, new UserName("abc"));

        // Act & Assert
        assertEquals(user.getId(), userId);
    }

    @Test
    @DisplayName("UserName を取得できる")
    void expectToGetUserName() {

        // Arrange
        UserName userName = new UserName("abc");
        User user = new User(new UserId("123"), userName);

        // Act & Assert
        assertEquals(user.getName(), userName);
    }
}
