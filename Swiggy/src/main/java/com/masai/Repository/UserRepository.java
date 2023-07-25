package com.masai.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Model.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByuserName(String userName);
}
