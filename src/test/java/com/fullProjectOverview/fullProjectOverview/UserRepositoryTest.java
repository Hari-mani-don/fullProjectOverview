package com.fullProjectOverview.fullProjectOverview;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fullProjectOverview.fullProjectOverview.dao.User;
import com.fullProjectOverview.fullProjectOverview.repository.UserRepository;

@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

//	@BeforeEach
//	public void setUp() {
//		// Initialize test data in the database before each test
//		User user1 = new User();
//		user1.setEmail("hari@gmail.com");
//		user1.setUserName("Harish");
//		user1.setPassword("password123");
//		userRepository.save(user1);
//
//		User user2 = new User();
//		user2.setEmail("test@example.com");
//		user2.setUserName("TestUser");
//		user2.setPassword("password456");
//		userRepository.save(user2);
//	}

	@Test
	public void testFindByUserName() {
		List<User> users = userRepository.findByUserName("Harish");
		assertEquals(1, users.size());
		assertEquals("hari@gmail.com", users.get(0).getEmail());
	}

	@Test
	public void testFindByUserNameAndEmail() {
		List<User> users = userRepository.findByUserNameAndEmail("Harish", "hari@gmail.com");
		assertEquals(1, users.size());
		assertEquals("Harish", users.get(0).getUserName());
		assertEquals("hari@gmail.com", users.get(0).getEmail());
	}

	@Test
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void testSaveUser() {
		User user = new User();
		user.setEmail("newuser@example.com");
		user.setUserName("NewUser");
		user.setPassword("password789"); // Set the password
		userRepository.save(user);

		Optional<User> savedUser = userRepository.findById(user.getUserId());
		assertEquals(true, savedUser.isPresent());
		assertEquals("newuser@example.com", savedUser.get().getEmail());
	}

	@Test
	public void testDeleteUser() {
		User user = userRepository.findByUserName("Harish").get(0);
		userRepository.delete(user);

		List<User> users = userRepository.findByUserName("Harish");
		assertEquals(0, users.size());
	}
}
