package com.mycompany.user.service.impl;

import com.mycompany.user.dao.UserPhoneRepository;
import com.mycompany.user.dao.UserRepository;
import com.mycompany.user.exception.type.ConflictDataException;
import com.mycompany.user.mapper.UserMapper;
import com.mycompany.user.model.business.rq.UserRq;
import com.mycompany.user.model.business.rs.User;
import com.mycompany.user.model.thirdparty.UserDTO;
import com.mycompany.user.util.JwtUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {


    @Mock
    private UserRepository userRepository;

    @Mock
    private UserPhoneRepository userPhoneRepository;

    @Mock
    private UserMapper userMapper;

    @Mock
    private JwtUtils jwtUtils;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void create_success() {
        UserRq userRq = new UserRq();
        userRq.setEmail("test@example.com");

        UserDTO userDTO = new UserDTO();

        User userResponse = new User();
        when(userRepository.existsByEmail(userRq.getEmail())).thenReturn(false);
        when(userMapper.userToUserDTO(userRq)).thenReturn(userDTO);
        when(userRepository.save(userDTO)).thenReturn(userDTO);
        when(jwtUtils.generateJwtToken(userRq.getName())).thenReturn("token");
        when(userMapper.userDTOToUserRs(userDTO)).thenReturn(userResponse);

        ResponseEntity<User> response = userService.create(userRq);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(userResponse, response.getBody());
        verify(userRepository).save(userDTO);
        verify(userPhoneRepository).saveAll(anyList());
    }

    @Test
    void create_emailAlreadyExists() {
        UserRq userRq = new UserRq();
        userRq.setEmail("test@example.com");

        when(userRepository.existsByEmail(userRq.getEmail())).thenReturn(true);

        assertThrows(ConflictDataException.class, () -> userService.create(userRq));

        verify(userRepository, never()).save(any());
        verify(userPhoneRepository, never()).saveAll(anyList());
    }
}
