package com.mycompany.user.service;


import com.mycompany.user.model.business.rq.LoginRequest;
import com.mycompany.user.model.business.rq.UserRq;
import com.mycompany.user.model.business.rs.MessageRs;
import com.mycompany.user.model.business.rs.User;
import org.springframework.http.ResponseEntity;


public interface UserService {

    ResponseEntity<MessageRs> validJWT(String tokenJWT, LoginRequest loginRequest);

    ResponseEntity<User> create(UserRq user);


}
