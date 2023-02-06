package com.bookreview.api.user;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// import org.hibernate.validator.constraints.UUID;

import lombok.Data;

@Entity
@Table(name="Users")
@Data
public class User {
	@Id
	@GeneratedValue
	private UUID Id;
	
	private String username;
	private String displayName;
	private String password;
	private String bio;
	private String country;
	private String city;

}
