package ru.otus.spring.homework.examBoot.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.RequiredArgsConstructor;
import ru.otus.spring.homework.examBoot.model.Question;
import ru.otus.spring.homework.examBoot.utils.LocalizationProperties;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QuestionsDaoImpl implements QuestionsDao {

    private final LocalizationProperties localizationProperties;

    @Override
    public List<Question> getQuestions() {
        List<Question> result = new ArrayList<>();

        try (Scanner scanner = new Scanner(getFileFromResources(localizationProperties.getLocalizedFileNames()))) {
            while (scanner.hasNextLine()) {
                result.add(getQuestionFromLine(scanner.nextLine(), ";"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }

    private File getFileFromResources(List<String> fileNames) {
        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileNames.get(0));
        if (resource == null) {
            resource = classLoader.getResource(fileNames.get(1));
        }

        return new File(resource.getFile());
    }

    private static Question getQuestionFromLine(String line, String delimeter) {
        List<String> values = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(delimeter);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return new Question(values.get(0), values.get(1));
    }
}