package com.mycompany.user.model.business;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserPhones {
    private Long id;
    private UUID userId;
    private String number;
    private String cityCode;
    private String countryCode;
}
