package ru.otus.spring.homework.examBoot.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import ru.otus.spring.homework.examBoot.config.Properties;
import ru.otus.spring.homework.examBoot.dao.QuestionsDao;
import ru.otus.spring.homework.examBoot.model.Question;
import ru.otus.spring.homework.examBoot.model.Student;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl implements ExamService {

    private final Properties yamlProperties;
    private final QuestionsDao questionsDao;
    private final RegistrationService registrationService;
    private final InputOutputService inputOutputService;
    private Student student;

    public ExamServiceImpl(Properties yamlProperties,
                           QuestionsDao questionsDao,
                           RegistrationService registrationService,
                           InputOutputService inputOutputService) {
        this.yamlProperties = yamlProperties;
        this.questionsDao = questionsDao;
        this.registrationService = registrationService;
        this.inputOutputService = inputOutputService;
    }

    @Override
    public void exam() {
        student = registrationService.registerStudent();

        int score = takeExam(questionsDao.getQuestions());

        student.setScore(score);
        student.setExamPassed(score >= yamlProperties.getScoreToPass());

        if (student.isExamPassed()) {
            inputOutputService.printMessage("exam.passed", student.getName(), score);
        } else {
            inputOutputService.printMessage("exam.failed", student.getName(), score);
        }
    }

    private int takeExam(List<Question> questions) {
        int score = 0;
        for (Question question : questions) {
            inputOutputService.printLine(question.getQuestion());
            if (StringUtils.equals(inputOutputService.readLine().toLowerCase(), question.getAnswer().toLowerCase())) {
                score++;
            }
        }
        return score;
    }
}