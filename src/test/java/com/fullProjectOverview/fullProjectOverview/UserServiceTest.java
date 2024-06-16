package com.fullProjectOverview.fullProjectOverview;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fullProjectOverview.fullProjectOverview.dao.User;
import com.fullProjectOverview.fullProjectOverview.repository.UserRepository;
import com.fullProjectOverview.fullProjectOverview.service.UserManagementService;

@SpringBootTest
public class UserServiceTest {
	@Autowired
	UserRepository userRepository;
	UserManagementService userService = null;

	@BeforeEach
	public void setUp() {
		userService = new UserManagementService(userRepository);
	}

	@Test
	public void testUpdateUser() {
		User user = new User();
		user.setPassword("harish");
		user.setUserName("hariManidondododndododnno");
		user.setEmail("askjflsdjfsl");

		User users = userService.updateUser(15, user);
		Optional<User> use = userRepository.findById(15);

		assertTrue(use.isPresent());
	}
}
