package com.mycompany.user.model.business.rq;

import com.mycompany.user.model.business.UserPhones;
import com.mycompany.user.util.EmailRegex;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserRq {

    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username can only contain alphanumeric characters and underscores")
    private String name;

    @EmailRegex
    private String email;

    @Size(min = 8, max = 120)
    private String password;

    private List<UserPhones> phones = new ArrayList<>();
}
