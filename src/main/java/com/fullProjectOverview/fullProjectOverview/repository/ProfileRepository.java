package com.fullProjectOverview.fullProjectOverview.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullProjectOverview.fullProjectOverview.dao.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
//	@Query("select * from profiles where id=:userId")
//	Profile findByUserId(@Param(value = "userId") Integer userId);
	
	Profile findByUser_UserId(Integer userId);
}
