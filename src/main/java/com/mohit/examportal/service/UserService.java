package com.mohit.examportal.service;

import com.mohit.examportal.entity.User;
import com.mohit.examportal.entity.UserRole;

import java.util.Set;

public interface UserService {
    public User createUser(User user, Set<UserRole> userRoles)throws Exception;
}
