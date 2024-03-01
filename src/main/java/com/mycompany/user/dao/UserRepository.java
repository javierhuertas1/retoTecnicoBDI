package com.mycompany.user.dao;

import com.mycompany.user.model.thirdparty.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserDTO, UUID> {
    Boolean existsByEmail(String email);
}