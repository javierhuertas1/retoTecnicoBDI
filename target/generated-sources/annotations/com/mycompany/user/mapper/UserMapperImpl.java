package com.mycompany.user.mapper;

import com.mycompany.user.model.business.rq.UserRq;
import com.mycompany.user.model.business.rs.User;
import com.mycompany.user.model.thirdparty.UserDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-01T08:35:58-0500",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User userDTOToUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );
        user.setCreated( userDTO.getCreated() );
        user.setModified( userDTO.getModified() );
        user.setLastLogin( userDTO.getLastLogin() );
        user.setToken( userDTO.getToken() );
        user.setActive( userDTO.isActive() );

        return user;
    }

    @Override
    public User userDTOToUserRs(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );
        user.setCreated( userDTO.getCreated() );
        user.setModified( userDTO.getModified() );
        user.setLastLogin( userDTO.getLastLogin() );
        user.setToken( userDTO.getToken() );
        user.setActive( userDTO.isActive() );

        return user;
    }

    @Override
    public UserDTO userToUserDTO(UserRq user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setName( user.getName() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setPassword( user.getPassword() );

        return userDTO;
    }
}
