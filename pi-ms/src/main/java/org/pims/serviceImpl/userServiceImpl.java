package org.pims.serviceImpl;

import org.pims.dao.UserRepository;
import org.pims.dto.UserDTO;
import org.pims.model.User;
import org.pims.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class userServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<UserDTO> getUsers() {
        List<User> allUsers = new ArrayList<>();
        allUsers =  userRepository.findAll();
        return allUsers.stream().map(user -> mapToUserDTO(user)).collect(Collectors.toList());
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User user = new User();
        user = mapToUser(userDTO);
        user = userRepository.save(user);
        return mapToUserDTO(user);
    }

    @Override
    public UserDTO getUserById(int userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user,userDTO);
            return userDTO;
        }
        return null;
    }
    // Type Converter methods
    private User mapToUser(UserDTO userDTO){
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        return user;
    }
    private UserDTO mapToUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }
}
