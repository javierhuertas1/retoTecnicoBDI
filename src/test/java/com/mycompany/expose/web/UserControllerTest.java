package com.mycompany.expose.web;

import com.mycompany.user.model.business.rq.UserRq;
import com.mycompany.user.model.business.rs.User;
import com.mycompany.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    public void testRegisterUser_Success() {
        // Arrange
        UserRq userRq = new UserRq();
        User user = new User();

        when(userService.create(userRq)).thenReturn(new ResponseEntity<>(user, HttpStatus.CREATED));

        // Act
        ResponseEntity<User> responseEntity = userController.create(userRq);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(user, responseEntity.getBody());
        verify(userService, times(1)).create(userRq);
    }

}
