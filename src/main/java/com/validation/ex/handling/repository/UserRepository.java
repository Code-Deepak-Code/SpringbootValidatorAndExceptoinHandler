package com.validation.ex.handling.repository;

import com.validation.ex.handling.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUserId(int id);

}
