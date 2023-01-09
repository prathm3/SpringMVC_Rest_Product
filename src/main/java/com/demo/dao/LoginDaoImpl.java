package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.User;

@Repository
public class LoginDaoImpl implements LoginDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public User validateUser(String user, String password) {
		
		return jdbcTemplate.queryForObject("select * from users where user=? and password=?",
				new Object[] {user,password},BeanPropertyRowMapper.newInstance(User.class));
		}
	
	

}
