import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.pwr.ite.bd2.client.web.dto.LessonDto;
import pl.pwr.ite.bd2.client.web.dto.SchoolClassDto;
import pl.pwr.ite.bd2.client.web.dto.SchoolSubjectDto;
import pl.pwr.ite.bd2.client.web.dto.TeacherDto;
import pl.pwr.ite.bd2.client.web.mapper.LessonMapper;
import pl.pwr.ite.bd2.client.web.service.LessonFacade;
import pl.pwr.ite.bd2.model.entity.Lesson;
import pl.pwr.ite.bd2.model.entity.SchoolClass;
import pl.pwr.ite.bd2.model.entity.SchoolSubject;
import pl.pwr.ite.bd2.model.entity.Teacher;
import pl.pwr.ite.bd2.service.*;
import pl.pwr.ite.bd2.web.SecurityFacade;
import pl.pwr.ite.bd2.web.TypedPageMapper;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class LessonFacadeTest {

    @TestConfiguration
    static class TestConfig {
        @Bean
        public LessonFacade lessonFacade(LessonService lessonService, LessonMapper lessonMapper,
                                         SecurityFacade securityFacade, SchoolClassService schoolClassService,
                                         TeacherService teacherService, SchoolSubjectService schoolSubjectService) {
            return new LessonFacade(lessonService, lessonMapper, securityFacade, schoolClassService, teacherService, schoolSubjectService);
        }
    }

    // COMMON FOR EVERY FACADE TEST
    @MockBean private SecurityFacade securityFacade;
    @MockBean private MappingService mappingService;
    @MockBean private TypedPageMapper typedPageMapper;

    @MockBean private LessonService lessonService;
    @MockBean private LessonMapper lessonMapper;
    @MockBean private SchoolClassService schoolClassService;
    @MockBean private TeacherService teacherService;
    @MockBean private SchoolSubjectService schoolSubjectService;

    @Autowired private LessonFacade lessonFacade;/* = new LessonFacade(lessonService, lessonMapper, securityFacade, schoolClassService, teacherService, schoolSubjectService)*/;

    private static final UUID LESSON_ID = UUID.fromString("2d65d9da-cf71-4d18-a2bb-abfd371bf3cc");
    private static final UUID SCHOOL_CLASS_ID = UUID.fromString("2daf6b93-8c6c-40e6-9033-10a321321a63");
    private static final UUID TEACHER_ID = UUID.fromString("e1c3c945-6258-40e1-a446-ba7e9339c0dc");
    private static final UUID SCHOOL_SUBJECT_ID = UUID.fromString("99cba2fe-29cc-4895-b74d-7270c6b44b74");

    @BeforeEach
    public void setUp() {
        var schoolClass = new SchoolClass();
        schoolClass.setId(SCHOOL_CLASS_ID);
        when(schoolClassService.findById(SCHOOL_CLASS_ID)).thenReturn(schoolClass);

        var teacher = new Teacher();
        teacher.setId(TEACHER_ID);
        when(teacherService.findById(TEACHER_ID)).thenReturn(teacher);

        var schoolSubject = new SchoolSubject();
        schoolSubject.setId(SCHOOL_SUBJECT_ID);
        when(schoolSubjectService.findById(SCHOOL_SUBJECT_ID)).thenReturn(schoolSubject);

        when(lessonService.saveAndFlush(any()))
                .thenAnswer(invocation -> {
                    var lesson = invocation.getArgument(0, Lesson.class);
                    lesson.setId(LESSON_ID);
                    return lesson;
                });
    }

    @Test
    public void givenDto_shouldReturnValidEntity() {
        var lessonDto = new LessonDto();

        var schoolClassDto = new SchoolClassDto();
        schoolClassDto.setId(SCHOOL_CLASS_ID);
        var teacherDto = new TeacherDto();
        teacherDto.setId(TEACHER_ID);
        var schoolSubjectDto = new SchoolSubjectDto();
        schoolSubjectDto.setId(SCHOOL_SUBJECT_ID);

        lessonDto.setStudentClass(schoolClassDto);
        lessonDto.setTeacher(teacherDto);
        lessonDto.setSchoolSubject(schoolSubjectDto);

        var lesson = lessonFacade.create(lessonDto);

        assertThat(lesson.getId()).isEqualTo(LESSON_ID);
        assertThat(lesson.getStudentClass().getId()).isEqualTo(SCHOOL_CLASS_ID);
        assertThat(lesson.getTeacher().getId()).isEqualTo(TEACHER_ID);
        assertThat(lesson.getSchoolSubject().getId()).isEqualTo(SCHOOL_SUBJECT_ID);
    }
}
