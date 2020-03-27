package ru.otus.spring.homework.examBoot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "application")
public class YamlProperties {

    private int scoreToPass;
    private Filename questionsFile = new Filename();
    private String locale;

    @Data
    class Filename {
        private String name;
        private String extension;
    }
}
