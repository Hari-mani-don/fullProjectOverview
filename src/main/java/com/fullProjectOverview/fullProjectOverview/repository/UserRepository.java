package com.fullProjectOverview.fullProjectOverview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fullProjectOverview.fullProjectOverview.dao.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByUserName(String name);
	List<User> findByPassword(String name);
	User findByUserId(Integer id);
//	User findByUserId(Integer userId);
	
//	@Query(value  = " select user_id, user_email,user_password from users",nativeQuery =true)
//	String findByHellosss();
	
	@Query( " from User where userId=:id")
	User findByHello(Integer id);
	
	List<User> findByUserNameAndPassword(String userName, String password);
	List<User> findByUserNameAndEmail(String userName, String password);
}
