package ru.otus.spring.homework.examBoot.utils;

import java.util.Locale;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LocalizationProperties {

    private final String questionsFileName;
    private final String questionsFileExtension;
    @Getter
    private final Locale locale;

    public String getLocalizedFileName() {
        StringBuilder stringBuilder = new StringBuilder(questionsFileName);
        if (locale != Locale.getDefault()) {
            stringBuilder.append("_").append(locale.toLanguageTag());
        }
        stringBuilder.append(".").append(questionsFileExtension);

        return stringBuilder.toString();
    }
}