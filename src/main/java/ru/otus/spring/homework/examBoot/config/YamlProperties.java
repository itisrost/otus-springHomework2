package ru.otus.spring.homework.examBoot.config;

import lombok.Data;
import ru.otus.spring.homework.examBoot.model.Filename;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "application")
public class YamlProperties {

    private int scoreToPass;
    private Filename questionsFile = new Filename();
    private String locale;
}
