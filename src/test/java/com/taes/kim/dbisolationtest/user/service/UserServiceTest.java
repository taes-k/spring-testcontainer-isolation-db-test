package com.taes.kim.dbisolationtest.user.service;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.taes.kim.dbisolationtest.UnitTest;
import com.taes.kim.dbisolationtest.user.entity.User;
import com.taes.kim.dbisolationtest.user.repository.UserRepository;

@DisplayName("UserService 단위 테스트")
public class UserServiceTest extends UnitTest {

    @Mock
    UserRepository userRepository = Mockito.mock(UserRepository.class);

    @Test
    void findUserTest() {
        // given
        UserService userService = new UserServiceImpl(userRepository);
        String givneId = "test_id";
        User givenUser = new User(givneId, "1234", "테스터");

        // when
        Mockito.when(userRepository.findById(givneId)).thenReturn(Optional.of(givenUser));

        // then
        Assertions.assertEquals(givneId, givenUser.getId());
    }
}
