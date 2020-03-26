package ru.otus.spring.homework.examBoot.dao;

import java.util.List;

import ru.otus.spring.homework.examBoot.model.Question;


public interface QuestionsDao {

    List<Question> getQuestions();

}
