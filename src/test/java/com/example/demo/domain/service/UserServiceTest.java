package com.example.demo.domain.service;

import com.example.demo.domain.models.user.User;
import com.example.demo.domain.models.user.UserId;
import com.example.demo.domain.models.user.UserName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UserServiceTest {

    @Test
    @DisplayName("ユーザの存在を確認して false を返す（仮）")
    void whenCheckingExistence_expectToReturnFalse() {

        // Arrange
        UserService userService = new UserService();

        // Act & Assert
        assertThat(
                userService.exists(
                        new User(
                                new UserId("123"),
                                new UserName("abc")
                        )
                )
        ).isFalse();
    }
}
