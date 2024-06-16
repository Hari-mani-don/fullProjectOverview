package com.fullProjectOverview.fullProjectOverview.service;

import java.util.List;

import com.fullProjectOverview.fullProjectOverview.dao.Profile;
import com.fullProjectOverview.fullProjectOverview.dao.User;

public interface ProfileService {

	Profile createProfile(Profile profile);

	Profile updateProfile(Integer id, Profile profile);

	List<Profile> findAllProfile();

	void deleteProfile(Integer profileId);

	

}
