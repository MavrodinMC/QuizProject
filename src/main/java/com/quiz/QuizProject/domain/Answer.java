package com.quiz.QuizProject.domain;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "QUESTION_ID", insertable = false, updatable = false)
    private Integer questionId;

    @Column(name = "OPTION")
    private String option;

    @Column(name = "IS_VALID")
    private boolean isValid;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    public Answer() {
    }

    public Answer(String option, boolean isValid) {
        this.option = option;
        this.isValid = isValid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(boolean valid) {
        isValid = valid;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
//                ", questionId=" + questionId +
                ", option='" + option + '\'' +
                ", isValid=" + isValid +
                '}';
    }
}
