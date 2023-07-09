package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
//import com.example.demo.entity.User;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;


@Repository
//public interface UserRepository extends JpaRepository<User, Long> {
public class UserRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void save(User user) {
		//String sql3 = "INSERT INTO user (ID) VALUES (?, ?, ...)";
		//jdbcTemplate.update("user" + user);
		String sql = "INSERT INTO user (ID) VALUES (?)";
		jdbcTemplate.update(sql, user.getUsername());
	}

    // 定義方法
	//void save(com.example.demo.entity.User user);

}
