package com.mycompany.user.model.business.rq;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;


@Getter
public class LoginRequest {

    @NotBlank
    @Size(min = 8, max = 67)
    @Email
    private String email;

    @NotBlank
    @Size(min = 8, max = 16)
    private String password;

}
