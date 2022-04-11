package com.mohit.examportal.service;

import com.mohit.examportal.entity.User;
import com.mohit.examportal.entity.UserRole;

import java.util.Set;

public interface UserService {
    //create user
    public User createUser(User user, Set<UserRole> userRoles)throws Exception;

    //get user by username
    public User getUser(String username);

    //delete user by id
    public void deleteUser(Long userId);
}
