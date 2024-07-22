package com.employee.servies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.User;
import com.employee.repo.UserRepo;

@Service
public class UserServise {
	@Autowired
	private UserRepo repo;
	
	public User insertUser(User user)
	{
		return repo.save(user);

	}
	public User find(int id)
	{
		return repo.findById(id).get();
	}
}
