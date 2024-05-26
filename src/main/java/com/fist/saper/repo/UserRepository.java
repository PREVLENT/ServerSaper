package com.fist.saper.repo;


import com.fist.saper.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByName(String name);
    List<User> findByOrderByPoints();
}
