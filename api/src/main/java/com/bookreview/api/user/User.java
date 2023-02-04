package com.bookreview.api.user;

import lombok.Data;

@Data
public class User {
	private String username;
	private String displayName;
	private String password;
	private String bio;
	private String country;
	private String city;
	

}
