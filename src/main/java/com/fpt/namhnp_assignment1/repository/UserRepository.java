package com.fpt.namhnp_assignment1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fpt.namhnp_assignment1.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	@Query(value="select u.user_id, u.username, u.userpass from users u where u.username = :username", nativeQuery = true)
	User findUserByUsername(@Param("username") String username);

}
