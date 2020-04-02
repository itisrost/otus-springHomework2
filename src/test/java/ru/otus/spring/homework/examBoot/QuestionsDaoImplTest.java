package ru.otus.spring.homework.examBoot;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.spring.homework.examBoot.dao.QuestionsDao;
import ru.otus.spring.homework.examBoot.dao.QuestionsDaoImpl;
import ru.otus.spring.homework.examBoot.model.Question;
import ru.otus.spring.homework.examBoot.utils.LocalizationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@DisplayName("Тестируем QuestionsDaoImpl")
class QuestionsDaoImplTest {

	@Mock
	private LocalizationProperties localizedFileNameProvider;

	@Test
	@DisplayName("Тестируем метод getQuestions")
	void getQuestionsTest() {

		Mockito.when(localizedFileNameProvider.getLocalizedFileNames())
				.thenReturn(Collections.singletonList("testQuestions.csv"));

		QuestionsDao questionsDao = new QuestionsDaoImpl(localizedFileNameProvider);

		List<Question> questions = questionsDao.getQuestions();

		assertNotNull(questions, "question list is null");
		assertNotEquals(0, questions.size(), "question list is empty");
		assertEquals(2, questions.size());
		assertEquals("Test question 1?", questions.get(0).getQuestion());
		assertEquals("answer2", questions.get(1).getAnswer());
	}

}