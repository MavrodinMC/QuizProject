package com.quiz.QuizProject.service.impl;

import com.quiz.QuizProject.domain.Answer;
import com.quiz.QuizProject.domain.Question;
import com.quiz.QuizProject.repository.AnswerRepository;
import com.quiz.QuizProject.repository.QuestionRepository;
import com.quiz.QuizProject.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;


    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Transactional
    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public void deleteQuestionById(int id) {
        questionRepository.deleteById(id);
    }

    @Override
    public void editPersonById(Question question) {
        questionRepository.save(question);
    }

    @Override
    public Question findOneById(int id) {
        return questionRepository.getOne(id);
    }

    @Override
    public void saveAnswers(List<Answer> answers) {
        answers.forEach(a -> {
            answerRepository.save(a);
        });
    }

}
