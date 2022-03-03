package org.pims.controller;

import org.pims.dto.UserDTO;
import org.pims.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee-services/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping()
    public List<UserDTO> getUsers() {
        List<UserDTO> users = new ArrayList<UserDTO>();
        users = userService.getUsers();
        return users;
    }

    @GetMapping("/{userId}")
    public UserDTO getUserById(@PathVariable("userId") int userId){
        return userService.getUserById(userId);
    }

    @PostMapping()
    public UserDTO addUser(@RequestBody UserDTO userDTO){
        return this.userService.addUser(userDTO);
    }
}
