package ru.otus.spring.homework.examBoot.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import ru.otus.spring.homework.examBoot.config.Properties;
import org.springframework.stereotype.Component;

@Component
public class LocalizationProperties {

    private final Properties properties;

    @Getter
    private Locale locale;

    public LocalizationProperties(Properties properties) {
        this.properties = properties;

        if (StringUtils.isBlank(properties.getLocale())) {
            locale = Locale.getDefault();
        } else {
            locale = Locale.forLanguageTag(properties.getLocale());
        }
    }

    public String getLocalizedFileName() {
        StringBuilder stringBuilder = new StringBuilder(properties.getQuestionsFile().getName());
        if (locale != Locale.getDefault()) {
            stringBuilder.append("_").append(locale.toLanguageTag());
        }
        stringBuilder.append(".").append(properties.getQuestionsFile().getExtension());

        return stringBuilder.toString();
    }

    public List<String> getLocalizedFileNames() {
        StringBuilder localizedName = new StringBuilder(properties.getQuestionsFile().getName());
        localizedName.append("_")
                .append(locale.toLanguageTag())
                .append(".")
                .append(properties.getQuestionsFile().getExtension());

        StringBuilder defaultName = new StringBuilder(properties.getQuestionsFile().getName());
        defaultName.append(".").append(properties.getQuestionsFile().getExtension());

        return Arrays.asList(localizedName.toString(), defaultName.toString());
    }
}