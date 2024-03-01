package com.mycompany.user.dao;

import com.mycompany.user.model.thirdparty.UserPhonesDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPhoneRepository extends JpaRepository<UserPhonesDTO, Long> {
}
