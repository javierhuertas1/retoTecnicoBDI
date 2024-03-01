package com.mycompany.user.mapper;


import com.mycompany.user.model.business.rq.UserRq;
import com.mycompany.user.model.business.rs.User;
import com.mycompany.user.model.thirdparty.UserDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {
    User userDTOToUser(UserDTO userDTO);

    User userDTOToUserRs(UserDTO userDTO);

    UserDTO userToUserDTO(UserRq user);

}
