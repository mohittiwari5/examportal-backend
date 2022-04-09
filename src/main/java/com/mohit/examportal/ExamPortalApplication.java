package com.mohit.examportal;

import com.mohit.examportal.entity.Role;
import com.mohit.examportal.entity.User;
import com.mohit.examportal.entity.UserRole;
import com.mohit.examportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamPortalApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ExamPortalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("starting code");
		User user = new User();
		user.setFirstName("Mohit");
		user.setLastName("Tiwari");
		user.setUsername("mohit");
		user.setPassword("mohit");
		user.setEmail("moh@gmail.com");

		Role role =new Role();
		role.setRoleId(4L);
		role.setRoleName("ADMIN");

		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);

		Set<UserRole> userRoleSet = new HashSet<>();
		userRoleSet.add(userRole);

		User user1 = this.userService.createUser(user, userRoleSet);
		System.out.println(user1.getUsername());

	}
}
