package com.quiz.QuizProject.controller;

import com.quiz.QuizProject.domain.Answer;
import com.quiz.QuizProject.domain.Question;
import com.quiz.QuizProject.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping(value = "/index")
    public String showQuestions(Model model) {

        List<Question> questionList = questionService.findAll();

        model.addAttribute("questions", questionList);

        return "questions/index";
    }

    @GetMapping(value = "/add")
    public String showAddForm(Question question) {

        for (int i = 1; i <= 4; i++) {
            question.addAnswer(new Answer());
        }

        return "questions/add-question";
    }

    @PostMapping(value = "/add")
    public String addQuestion(Question question, BindingResult result, Model model) {
        question.getAnswers()
                .forEach(a -> a.setQuestion(question));

        Question questionDb = questionService.save(question);

        List<Question> questionList = questionService.findAll();

        model.addAttribute("questions", questionList);

        return "questions/index";
    }

    @GetMapping(value = "delete/{id}")

    public String deleteQuestionById(@PathVariable("id") int id, Model model) {

        questionService.deleteQuestionById(id);

        List<Question> questionList = questionService.findAll();

        model.addAttribute("questions", questionList);

        return "questions/index";
    }

    @GetMapping(value = "/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {

        Question question = questionService.findOneById(id);

        model.addAttribute("question", question);

        return "questions/update-question";
    }

    @PostMapping(value = "/edit")
    public String editQuestion(Question question, Model model) {
        questionService.save(question);

        List<Question> questionList = questionService.findAll();

        model.addAttribute("questions", questionList);

        return "questions/index";
    }


}




