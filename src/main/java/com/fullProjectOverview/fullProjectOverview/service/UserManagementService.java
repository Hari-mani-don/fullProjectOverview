package com.fullProjectOverview.fullProjectOverview.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fullProjectOverview.fullProjectOverview.dao.Image;
import com.fullProjectOverview.fullProjectOverview.dao.Profile;
import com.fullProjectOverview.fullProjectOverview.dao.User;
import com.fullProjectOverview.fullProjectOverview.exception.IllegarArgumentException;
import com.fullProjectOverview.fullProjectOverview.repository.ImageRepository;
import com.fullProjectOverview.fullProjectOverview.repository.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class UserManagementService implements UserService {

	UserRepository userRepository;

	@Autowired
	ImageRepository imageRepository;
	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	public UserManagementService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	@Transactional
	public User createUser(User user) {
		Profile profile = user.getProfile();

		entityManager.persist(profile);

		entityManager.persist(user);
		return user;

	}

	@Override
	@Transactional
	public User updateUser(Integer id, User user) {
//
//		if (user.getEmail() == null || user.getPassword() == null || user.getUserName() == null) {
//
//			throw new IllegarArgumentException("user name password and email cannot be null");
//		}
//		//
//		Optional<User> optionalUser = userRepository.findById(id);
//
//		if (!optionalUser.isPresent()) {
//			throw new UserNotFoundException("user  not found");
//		}
//		User existingUser = optionalUser.get();
//		existingUser.setUserName(user.getUserName());
//		existingUser.setPassword(user.getPassword());
//		existingUser.setEmail(user.getEmail());
//		return userRepository.save(existingUser);

		Profile profile = user.getProfile();
		entityManager.merge(profile);
		entityManager.merge(user);
		return user;
	}

	@Override
	public void deleteUser(Integer id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new IllegarArgumentException("user not found");
		}
		userRepository.deleteById(id);
	}

	@Override
	public List<User> findAll() {

		return userRepository.findAll();
	}

	public List<User> findByName(String name, String password) {

		return userRepository.findByUserNameAndPassword(name, password);
	}

	public List<User> findByEmail(String name, String email) {

		return userRepository.findByUserNameAndEmail(name, email);
	}

	public User findByHellos(Integer id) {

		return userRepository.findByHello(id);
	}

	public User retriveByUserId(Integer id) {

		return userRepository.findByUserId(id);
	}

	public Image addImage(MultipartFile file) {

		Image image = new Image();
		image.setImageName(file.getOriginalFilename());
		image.setType(file.getContentType());

		try {
			image.setData(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return imageRepository.save(image);
	}

	public Image getImage(Integer imageId) throws IOException {

		return imageRepository.findById(imageId).orElse(null);
	}
}
