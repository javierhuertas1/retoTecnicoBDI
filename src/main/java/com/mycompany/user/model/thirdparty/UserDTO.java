package com.mycompany.user.model.thirdparty;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;


@Getter
@Setter
@Entity
@Table(name = "users")
public class UserDTO {

    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "uuid", updatable = false)
    private UUID id;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9_ ]+$", message = "Username can only contain alphanumeric characters, underscores, and spaces")
    @Column(name = "name", length = 125)
    private String name;

    private String email;

    private String password;

    private Date created;

    private Date modified;

    private Date lastLogin;

    private String token;

    private boolean isActive;

}
