package com.fullProjectOverview.fullProjectOverview.service;

import java.util.List;

import com.fullProjectOverview.fullProjectOverview.dao.User;

public interface UserService {

	User createUser(User user);

	User updateUser(Integer id, User user);

	void deleteUser(Integer id);

	List<User> findAll();
}
