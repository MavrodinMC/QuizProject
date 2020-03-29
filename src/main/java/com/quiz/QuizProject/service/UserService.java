package com.quiz.QuizProject.service;

import com.quiz.QuizProject.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void save(User user);

    void deleteUserById(int id);

    User findOneById(int id);
}
