package com.fullProjectOverview.fullProjectOverview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.fullProjectOverview.fullProjectOverview.dao.Profile;
import com.fullProjectOverview.fullProjectOverview.dao.User;

public class UserManagementControllerTest {

//	@Mock
//	private UserManagementService userManagementService;

	@Test
	public void testHandleCreateUser() {

		User user = new User();
		Profile profile = new Profile();

		profile.setPhoneNumber("9386387");
		profile.setProfileId(1);

		user.setUserName("HariMani");
		user.setEmail("HariMani@gmail.com");
		user.setPassword("h93mani486@iraH");
		user.setProfile(profile);
		user.setUserId(1);

		assertEquals(1, user.getUserId());
		assertEquals("HariMani@gmail.com", user.getEmail());
		assertEquals("h93mani486@iraH", user.getPassword());
		assertEquals("HariMani", user.getUserName());
		assertEquals(user.getProfile().getProfileId(), profile.getProfileId());
		assertEquals(user.getProfile().getPhoneNumber(), profile.getPhoneNumber());
		assertEquals(user.getProfile(), profile);

//		 assertNotNull(user.toString());
	}
}
