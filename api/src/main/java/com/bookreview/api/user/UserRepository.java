package com.bookreview.api.user;


import java.util.UUID;

// import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, UUID> {

}
