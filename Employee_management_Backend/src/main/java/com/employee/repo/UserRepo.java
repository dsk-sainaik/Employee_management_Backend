package com.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	User save(User user);

	User findByEmail(String email);

}
