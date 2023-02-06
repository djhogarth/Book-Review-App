package com.bookreview.api.user;




import org.hibernate.annotations.UuidGenerator;
import org.hibernate.validator.constraints.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue
	@UuidGenerator
	private UUID Id;
	private String username;
	private String displayName;
	private String password;
	private String bio;
	private String country;
	private String city;
	

}
