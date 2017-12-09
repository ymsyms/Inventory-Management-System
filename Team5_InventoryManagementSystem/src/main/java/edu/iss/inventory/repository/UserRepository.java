package edu.iss.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.inventory.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	@Query("SELECT u FROM User u WHERE u.userId=:userId")
	User findUserByUserId(@Param("userId") String userId);
	
	@Query("SELECT u FROM User u WHERE u.userName=:userName")
	User findUserByUserName(@Param("userName") String userName);
		
	@Query("SELECT u FROM User u WHERE u.userName=:username AND u.password=:password")
	User findUserByUserNameNPassword(@Param("username") String username, @Param("password") String password);
}
