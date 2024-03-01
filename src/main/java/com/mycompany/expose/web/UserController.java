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

    @PostMapping("/signUp")
    @Operation(summary = "Create user")
    public ResponseEntity<User> create(@Valid @RequestBody UserRq userRq) {

        return userService.create(userRq);
    }

}
