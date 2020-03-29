package com.quiz.QuizProject.repository;

import com.quiz.QuizProject.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer>, CrudRepository<Answer, Integer> {

}
