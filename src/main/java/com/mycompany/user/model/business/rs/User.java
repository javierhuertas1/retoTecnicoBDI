package com.mycompany.user.model.business.rs;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class User {

    private UUID id;

    private Date created;

    private Date modified;

    private Date lastLogin;

    private String token;

    private boolean isActive;


}
