package com.mycompany.expose.web;

import com.mycompany.user.model.business.rq.LoginRequest;
import com.mycompany.user.model.business.rq.UserRq;
import com.mycompany.user.model.business.rs.User;
import com.mycompany.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@AllArgsConstructor
@RequestMapping("/v1/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signIn")
    @Operation(summary = "Authenticate user with username and password")
    public ResponseEntity<User> login(@Valid @RequestBody LoginRequest loginRequest) {

        return userService.login(loginRequest);

    }

    @GetMapping("/getUserById/{userId}")
    @Operation(summary = "Get user info logged in by userId")
    public ResponseEntity<User> getUserById(@PathVariable("userId") UUID userId) {

        return userService.getUserById(userId);

    }

    @PostMapping("/signUp")
    @Operation(summary = "Create user")
    public ResponseEntity<User> create(@Valid @RequestBody UserRq userRq) {

        return userService.create(userRq);
    }

}
