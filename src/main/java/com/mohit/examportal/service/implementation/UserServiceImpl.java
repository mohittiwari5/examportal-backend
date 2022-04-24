package com.mohit.examportal.service.implementation;

import com.mohit.examportal.entity.User;
import com.mohit.examportal.entity.UserRole;
import com.mohit.examportal.helper.UserAlreadyPresentException;
import com.mohit.examportal.repository.RoleRepository;
import com.mohit.examportal.repository.UserRepository;
import com.mohit.examportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    //creating User
    @Override
    public User createUser(User user, Set<UserRole> userRoles)throws Exception {

        User tempUser = this.userRepository.findByUsername(user.getUsername());
        if(tempUser!=null){
            System.out.println("User is already there");
            throw  new UserAlreadyPresentException("User already Present");
        }
        else {
            //create user
            for (UserRole ur:userRoles){
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            tempUser = this.userRepository.save(user);
        }

        return tempUser;
    }

    //getting user by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }
}
