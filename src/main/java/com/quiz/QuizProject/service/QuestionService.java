package com.quiz.QuizProject.service;

import com.quiz.QuizProject.domain.Answer;
import com.quiz.QuizProject.domain.Question;

import java.util.List;

public interface QuestionService {

    List<Question> findAll();

    Question save(Question question);

    void deleteQuestionById(int id);

    void editPersonById(Question question);

    Question findOneById(int id);

    void saveAnswers(List<Answer> answers);
}
