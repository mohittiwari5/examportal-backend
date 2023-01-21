package com.mohit.examportal.controller;

import com.mohit.examportal.config.MySecurityConfig;
import com.mohit.examportal.entity.Role;
import com.mohit.examportal.entity.User;
import com.mohit.examportal.entity.UserRole;
import com.mohit.examportal.helper.UserAlreadyPresentException;
import com.mohit.examportal.helper.UserNotFoundException;
import com.mohit.examportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //creating user
    @PostMapping("/")
    public User createUser(@RequestBody User user)throws Exception{


        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

        Set<UserRole> roles = new HashSet<>();
        Role role=new Role();
        role.setRoleId(45L);
        role.setRoleName("NORMAL");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);

        return this.userService.createUser(user,roles);

    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){

        return this.userService.getUser(username);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        this.userService.deleteUser(userId);
    }

//    @ExceptionHandler(UserAlreadyPresentException.class)
//    public ResponseEntity<?> exceptionHandler(UserAlreadyPresentException e){
//        return
//    }

}
