package com.fullProjectOverview.fullProjectOverview.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullProjectOverview.fullProjectOverview.dao.Profile;
import com.fullProjectOverview.fullProjectOverview.exception.UserNotFoundException;
import com.fullProjectOverview.fullProjectOverview.repository.ProfileRepository;

@Service
public class ProfileManagementService implements ProfileService {

	@Autowired
	ProfileRepository profileRepository;

	@Override
	public Profile createProfile(Profile profile) {
		if (profile.getPhoneNumber() == null) {
			throw new NullPointerException("phonenumber is null");
		}

		return profileRepository.save(profile);
	}

	@Override
	public Profile updateProfile(Integer id, Profile profile) {
		Optional<Profile> profileOpt = profileRepository.findById(id);
		if (!profileOpt.isPresent()) {
			throw new UserNotFoundException("Profile not found");
		}
		Profile existingProfile = profileOpt.get();
		existingProfile.setPhoneNumber(profile.getPhoneNumber());
		
		return profileRepository.save(existingProfile);

	}

	@Override
	public List<Profile> findAllProfile() {

		return profileRepository.findAll();
	}

	@Override
	public void deleteProfile(Integer profileId) {
		Optional<Profile> profile = profileRepository.findById(profileId);
		if (!profile.isPresent()) {
			throw new UserNotFoundException("User not found");
		}
		profileRepository.deleteById(profileId);

	}
	
	
	public Profile retriveUserProfileById(Integer userId) {
		
		Profile profileById = profileRepository.findByUser_UserId(userId);
		
		System.err.print(profileById.getProfileId()+""+ profileById.getPhoneNumber());
		return profileRepository.findByUser_UserId(userId);
	}

}
