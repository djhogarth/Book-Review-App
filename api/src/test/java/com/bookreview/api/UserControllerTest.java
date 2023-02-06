package com.bookreview.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.bookreview.api.user.User;
import com.bookreview.api.user.UserRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("dev")

public class UserControllerTest {

	private static final String API_USERS_PATH = "/api/1.0/users";

	@Autowired
	TestRestTemplate testRestTemplate;
	
	@Autowired
	UserRepository userRepository;

	@Test
	@Order(1)
	public void postUser_whenUserIsValid_receiveOk() {
		User appUser = createValidUser();

		ResponseEntity<Object> response = testRestTemplate.postForEntity(API_USERS_PATH, appUser, Object.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	private User createValidUser() {
		User user = new User();
		// test if the user name and display name are at least 4 characters long
		user.setUsername("testUser");
		user.setDisplayName("testdisplay");
		// test if password has at least one uppercase, one lowercase and one numeric
		user.setPassword("P4ssword");
		// test if the rest of fields have at least 4 characters
		user.setBio("loremIpsum12342");
		user.setCountry("Canada");
		user.setCity("Mississauga");
		return user;
	}

	@Test
	@Order(2)
	public void postUser_whenUserIsValid_SavedUserToDatabase() {
		User appUser = createValidUser();
		testRestTemplate.postForEntity(API_USERS_PATH, appUser,Object.class);
		assertThat(userRepository.count()).isEqualTo(1);
	}

}
