package ru.otus.spring.homework.examBoot.service;

public interface InputOutputService {

    String readLine();
    void printLine(String text);
    void printMessage(String messageName, Object... args);
}