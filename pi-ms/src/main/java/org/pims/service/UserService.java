package org.pims.service;

import org.pims.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();
    UserDTO addUser(UserDTO userDTO);
    UserDTO getUserById(int userId);
}
