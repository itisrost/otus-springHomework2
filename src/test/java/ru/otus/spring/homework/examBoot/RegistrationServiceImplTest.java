package ru.otus.spring.homework.examBoot;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.otus.spring.homework.examBoot.model.Student;
import ru.otus.spring.homework.examBoot.service.InputOutputService;
import ru.otus.spring.homework.examBoot.service.RegistrationService;
import ru.otus.spring.homework.examBoot.service.RegistrationServiceImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("Тестируем RegistrationServiceImpl")
public class RegistrationServiceImplTest {

    public static final String FREDDIE = "Freddie";

    @MockBean
    private InputOutputService inputOutputService;

    @Test
    @DisplayName("Пользователь создается корректно")
    void registerStudentTest(){
        Mockito.when(inputOutputService.readLine()).thenReturn(FREDDIE);

        RegistrationService registrationService = new RegistrationServiceImpl(inputOutputService);

        Student student = registrationService.registerStudent();
        assertNotNull(student, "student is null");
        assertEquals(student.getName(), FREDDIE);

    }
}
