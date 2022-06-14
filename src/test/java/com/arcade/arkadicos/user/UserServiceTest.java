package com.arcade.arkadicos.user;


import com.arcade.arkadicos.users.User;
import com.arcade.arkadicos.users.UserRepository;
import com.arcade.arkadicos.users.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public  class UserServiceTest {

    @Mock private UserRepository userRepositoryMock;

    private UserService userServiceUnderTest;

  @BeforeEach
    void setUp(){userServiceUnderTest = new UserService(userRepositoryMock);}

    @Test
    void canCreateUser() {
        // Give

        User user = new User(
                "Fran",
                "francito@hotmail.com",
                "francito"
        );
        Mockito.when(userServiceUnderTest.create(user)).thenReturn(user);

        //When
        User userActual = userServiceUnderTest.create(user);
        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
        //Then

        verify(userRepositoryMock).save(userArgumentCaptor.capture());

        User capturedUser = userArgumentCaptor.getValue();

        assertThat(capturedUser).isEqualTo(user);
        assertThat(userActual).isEqualTo(user);

    }
        @Test
        void canGetUserById() {

            //When
            userServiceUnderTest.getUserById(1L);

            ArgumentCaptor<Long> userIdArgumentCaptor = ArgumentCaptor.forClass(Long.class);

            //Then
            verify(userRepositoryMock).findById(userIdArgumentCaptor.capture());

            Long capturedProductId = userIdArgumentCaptor.getValue();

            assertThat(capturedProductId).isEqualTo(1L);
        }










    }
