package com.fullProjectOverview.fullProjectOverview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fullProjectOverview.fullProjectOverview.dao.Profile;
import com.fullProjectOverview.fullProjectOverview.dao.User;
import com.fullProjectOverview.fullProjectOverview.service.ProfileManagementService;

@RestController
@RequestMapping("/profile")
public class UserProfileController {

	@Autowired
	ProfileManagementService profileManagementService;

	@PostMapping("/profiles")
	public ResponseEntity<Profile> handleCreateProfile(@RequestBody Profile profile) {
		profileManagementService.createProfile(profile);
		return new ResponseEntity<Profile>(profile, HttpStatus.CREATED);
	}

	@PutMapping("/profiles")
	public ResponseEntity<Profile> handleUpdateProfile(@RequestParam(value = "id") Integer id,
			@RequestBody Profile profile) {
		profileManagementService.updateProfile(id, profile);
		return new ResponseEntity<Profile>(profile, HttpStatus.OK);
	}

	@DeleteMapping("/profiles/{id}")
	public void handleDeleteProfile(@PathVariable Integer id) {
		profileManagementService.deleteProfile(id);
	}

	@GetMapping("/users/profiles/{id}")
	public Profile handleUserProfileById(@PathVariable Integer id) {
		Profile profileById = profileManagementService.retriveUserProfileById(id);
		
		System.err.print(profileById.getProfileId()+""+ profileById.getPhoneNumber());
		
		return profileById;
	}

	@GetMapping("/profiles")
	public List<Profile> handleFindAllProfile() {
		return profileManagementService.findAllProfile();
	}

//	@GetMapping("/users/profile")
//	public Profile handleUserProfile(Integer useId) {
//
//		return profileManagementService.userProfile(useId);
//	}
}
