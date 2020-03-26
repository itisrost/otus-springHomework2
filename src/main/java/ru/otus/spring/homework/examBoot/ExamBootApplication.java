package ru.otus.spring.homework.examBoot;

import ru.otus.spring.homework.examBoot.config.YamlProperties;
import ru.otus.spring.homework.examBoot.service.ExamService;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(YamlProperties.class)
public class ExamBootApplication {

	public static void main(String[] args) {
		ListableBeanFactory ctx = SpringApplication.run(ExamBootApplication.class, args);

		ExamService examService = ctx.getBean(ExamService.class);

		examService.exam();
	}
}