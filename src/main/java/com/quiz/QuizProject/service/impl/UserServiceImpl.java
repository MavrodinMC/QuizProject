package com.quiz.QuizProject.service.impl;

import com.quiz.QuizProject.domain.User;
import com.quiz.QuizProject.repository.UserRepository;
import com.quiz.QuizProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
         userRepository.save(user);
    }


    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findOneById(int id) {
        return userRepository.getOne(id);
    }
}
