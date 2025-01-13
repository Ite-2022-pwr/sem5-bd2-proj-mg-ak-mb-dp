import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.pwr.ite.bd2.model.entity.Teacher;
import pl.pwr.ite.bd2.model.repository.TeacherRepository;
import pl.pwr.ite.bd2.service.TeacherService;
import pl.pwr.ite.bd2.service.impl.TeacherServiceImpl;

import javax.swing.*;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class TeacherServiceTest {

    @TestConfiguration
    static class TestConfig {
        @Bean
        public TeacherService teacherService(TeacherRepository teacherRepository) {
            return new TeacherServiceImpl(teacherRepository);
        }
    }

    @MockBean private TeacherRepository teacherRepository;

    @Autowired private TeacherService teacherService;

    private static final UUID TEACHER_ID = UUID.fromString("33dbef59-13b3-402c-af7f-15272aec4b02");

    @BeforeEach
    public void setUp() {
        var teacher = new Teacher();
        teacher.setId(TEACHER_ID);
        teacher.setOneLeave(true);

        when(teacherRepository.findById(any())).thenReturn(Optional.empty());
        when(teacherRepository.findById(TEACHER_ID)).thenReturn(Optional.of(teacher));
        doThrow(new IllegalArgumentException()).when(teacherRepository).delete(null);
    }

    @Test
    public void whenValidId_thenTeacherShouldBeFound() {
        var teacher = teacherService.findById(TEACHER_ID);
        assertTrue(teacher.getOneLeave());
    }

    @Test
    public void whenValidId_thenTeacherShouldNotBeFound() {
        var id = UUID.fromString("7466a3f1-63b5-4fc4-8e0e-0a409304670c");
        var teacher = teacherService.findById(id);
        assertNull(teacher);
    }

    @Test
    public void whenTeacherNull_thenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> teacherService.delete(null));
    }
}
