package com.bookreview.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.bookreview.api.user.User;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")

public class UserControllerTest {
	
private static final String API_USERS_PATH = "/api/1.0/users";
@Autowired
	TestRestTemplate testRestTemplate;
	
@Test
	public void postUser_whenUserIsValid_receiveOk( ) {
		User appUser = createValidUser();
		
		ResponseEntity<Object> response = testRestTemplate.postForEntity(API_USERS_PATH, appUser, Object.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

private User createValidUser() {
	User appUser = new User();
//		test if the user name and display name are at least 4 characters long
	appUser.setUsername("testUser");
	appUser.setDisplayName("testdisplay");
//		test if password has at least one uppercase, one lowercase and one numeric
	appUser.setPassword("P4ssword");
//		test if the rest of fields have at least 4 characters
	appUser.setBio("loremIpsum12342");
	appUser.setCountry("Canada");
	appUser.setCity("Mississauga");
	return appUser;
}

@Test
	public void postUser_whenUserIsValid_SavedUserToDatabase() {
	User appUser = createValidUser();
	testRestTemplate.postForEntity(API_USERS_PATH, appUser, Object.class);
	assertThat(userRepository.count()).isEqualTo(1);
}	

}
