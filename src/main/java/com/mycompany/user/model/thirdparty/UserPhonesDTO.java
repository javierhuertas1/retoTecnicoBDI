package com.mycompany.user.model.thirdparty;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "phones")
public class UserPhonesDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID userId;
    private String number;
    private String cityCode;
    private String countryCode;
}
