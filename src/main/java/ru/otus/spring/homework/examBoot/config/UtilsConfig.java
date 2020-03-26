package ru.otus.spring.homework.examBoot.config;

import java.util.Locale;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import ru.otus.spring.homework.examBoot.service.InputOutputServiceImpl;
import ru.otus.spring.homework.examBoot.utils.LocalizationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class UtilsConfig {

//    @Bean
//    public MessageSource messageSource() {
//        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
//        ms.setBasename("bundle");
//        ms.setDefaultEncoding("UTF-8");
//        return ms;
//    }

    @Bean
    public LocalizationProperties localizationProperties(YamlProperties yamlProperties) {
        if (StringUtils.isBlank(yamlProperties.getLocale())) {
            return new LocalizationProperties(yamlProperties.getQuestionsFile().getName(),
                    yamlProperties.getQuestionsFile().getExtension(),
                    Locale.getDefault());
        } else {
            return new LocalizationProperties(yamlProperties.getQuestionsFile().getName(),
                    yamlProperties.getQuestionsFile().getExtension(),
                    Locale.forLanguageTag(yamlProperties.getLocale()));
        }
    }

    @Bean
    public InputOutputServiceImpl consoleIO(MessageSource messageSource, LocalizationProperties localizationProperties) {
        return new InputOutputServiceImpl(messageSource, System.out, new Scanner(System.in), localizationProperties);
    }
}