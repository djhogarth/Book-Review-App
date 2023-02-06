package com.bookreview.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookreview.api.shared.GenericResponse;

@RestController

public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/api/1.0/users")
	GenericResponse createUser(@RequestBody User usr) {
		userService.saveUserToDatabase((usr));
		return new GenericResponse("User saved to database");
	}
	

}
