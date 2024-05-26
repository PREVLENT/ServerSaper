package com.fist.saper.service;

import com.fist.saper.model.User;
import com.fist.saper.repo.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public boolean checkName(String name) {
        if (userRepository.findAllByName(name).isEmpty()) {
            User user = new User(name, 0L);
            userRepository.save(user);
            return true;
        } else return false;
    }

    @Transactional
    public Long getScoreByName(String name) {
        return userRepository.findAllByName(name).get(0).getPoints();
    }

    @Transactional
    public void shareScore(String name, Long score) {
        User user = userRepository.findAllByName(name).get(0);
        user.setPoints(score);
        userRepository.save(user);
    }

    @Transactional
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
