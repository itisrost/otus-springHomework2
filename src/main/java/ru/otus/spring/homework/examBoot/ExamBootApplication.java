package ru.otus.spring.homework.examBoot;

import java.util.Locale;

import ru.otus.spring.homework.examBoot.config.Properties;
import ru.otus.spring.homework.examBoot.service.ExamService;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(Properties.class)
public class ExamBootApplication {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		ListableBeanFactory ctx = SpringApplication.run(ExamBootApplication.class, args);

		ExamService examService = ctx.getBean(ExamService.class);

		examService.exam();
	}
}