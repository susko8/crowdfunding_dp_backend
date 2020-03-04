package com.crowdfunding.dp.backend.dao;

import com.crowdfunding.dp.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface UserRepository extends JpaRepository<User, Integer>, Repository<User, Integer> {

    User findUserByLoginEquals(String login);
}
