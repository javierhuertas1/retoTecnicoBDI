package com.mycompany.user.service;


import com.mycompany.user.model.business.rq.LoginRequest;
import com.mycompany.user.model.business.rq.UserRq;
import com.mycompany.user.model.business.rs.User;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface UserService {

    ResponseEntity<User> login(LoginRequest loginRequest);

    ResponseEntity<User> getUserById(UUID id);

    ResponseEntity<User> create(UserRq user);


}
