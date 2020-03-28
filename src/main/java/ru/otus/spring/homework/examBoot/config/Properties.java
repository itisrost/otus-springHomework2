package ru.otus.spring.homework.examBoot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "application")
public class Properties {

    private int scoreToPass;
    private Filename questionsFile = new Filename();
    private String locale;

    @Data
    public class Filename {
        private String name;
        private String extension;
    }
}
