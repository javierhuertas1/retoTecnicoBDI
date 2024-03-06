package com.mycompany.user.service.impl;

import com.mycompany.user.dao.UserPhoneRepository;
import com.mycompany.user.dao.UserRepository;
import com.mycompany.user.exception.type.ConflictDataException;
import com.mycompany.user.exception.type.InternalServerErrorException;
import com.mycompany.user.mapper.UserMapper;
import com.mycompany.user.model.business.UserPhones;
import com.mycompany.user.model.business.rq.LoginRequest;
import com.mycompany.user.model.business.rq.UserRq;
import com.mycompany.user.model.business.rs.MessageRs;
import com.mycompany.user.model.business.rs.User;
import com.mycompany.user.model.thirdparty.UserDTO;
import com.mycompany.user.model.thirdparty.UserPhonesDTO;
import com.mycompany.user.service.UserService;
import com.mycompany.user.util.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserPhoneRepository userPhoneRepository;

    private final UserMapper userMapper;

    //private final PasswordEncoder encoder;

    private final JwtUtils jwtUtils;


    @Override
    public ResponseEntity<MessageRs> validJWT(String tokenJWT, LoginRequest loginRequest) {
        try {
            // Extract the token from the Authorization header
            String jwt = tokenJWT.substring("Bearer ".length());

            // Validate the token using the JwtUtils class
            boolean isValidToken = jwtUtils.validateJwtToken(jwt);

            if (isValidToken) {
                return ResponseEntity.ok(new MessageRs("JWT is valid"));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MessageRs("Invalid token."));
            }
        } catch (Exception e) {
            throw new InternalServerErrorException("Error processing request.");
        }

    }

    @Override
    public ResponseEntity<User> create(UserRq user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new ConflictDataException("Error: Email is already in use!");
        }

        UserDTO userDTO = userMapper.userToUserDTO(user);
        userDTO.setCreated(new Date());
        userDTO.setLastLogin(new Date());
        //userDTO.setPassword(encoder.encode(user.getPassword()));
        userDTO.setToken(jwtUtils.generateJwtToken(user.getName()));

        UserDTO userFromDB = userRepository.save(userDTO);
        List<UserPhonesDTO> userPhonesDTOs = buildPhones(user.getPhones(), userFromDB.getId());
        userPhoneRepository.saveAll(userPhonesDTOs);

        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.userDTOToUserRs(userFromDB));

    }

    private List<UserPhonesDTO> buildPhones(List<UserPhones> userPhones, UUID userId) {
        return userPhones.stream()
                .map(phone -> {
                    UserPhonesDTO phonesDTO = new UserPhonesDTO();
                    phonesDTO.setUserId(userId);
                    phonesDTO.setNumber(phone.getNumber());
                    phonesDTO.setCityCode(phone.getCityCode());
                    phonesDTO.setCountryCode(phone.getCountryCode());
                    return phonesDTO;
                })
                .toList();
    }
}
