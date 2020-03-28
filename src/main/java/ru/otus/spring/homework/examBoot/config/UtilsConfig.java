package ru.otus.spring.homework.examBoot.config;

import java.util.Scanner;

import ru.otus.spring.homework.examBoot.service.InputOutputServiceImpl;
import ru.otus.spring.homework.examBoot.utils.LocalizationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtilsConfig {

    @Bean
    public InputOutputServiceImpl consoleIO(MessageSource messageSource, LocalizationProperties localizationProperties) {
        return new InputOutputServiceImpl(messageSource, System.out, new Scanner(System.in), localizationProperties);
    }
}