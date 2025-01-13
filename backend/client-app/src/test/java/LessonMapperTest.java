import org.junit.jupiter.api.BeforeAll;
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
import pl.pwr.ite.bd2.client.web.mapper.SchoolClassMapper;
import pl.pwr.ite.bd2.client.web.mapper.SchoolSubjectMapper;
import pl.pwr.ite.bd2.client.web.mapper.TeacherMapper;
import pl.pwr.ite.bd2.client.web.service.LessonFacade;
import pl.pwr.ite.bd2.model.entity.Lesson;
import pl.pwr.ite.bd2.model.entity.SchoolClass;
import pl.pwr.ite.bd2.model.entity.SchoolSubject;
import pl.pwr.ite.bd2.model.entity.Teacher;
import pl.pwr.ite.bd2.service.*;
import pl.pwr.ite.bd2.service.impl.MappingServiceImpl;
import pl.pwr.ite.bd2.web.SecurityFacade;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class LessonMapperTest {

    @TestConfiguration
    static class TestConfig {
        @Bean
        public LessonMapper lessonFacade(SchoolClassMapper schoolClassMapper,
                                         TeacherMapper teacherMapper, SchoolSubjectMapper schoolSubjectMapper) {
            return new LessonMapper(schoolClassMapper, teacherMapper, schoolSubjectMapper);
        }
    }

    private static final UUID SCHOOL_CLASS_ID = UUID.randomUUID();
    private static final UUID TEACHER_ID = UUID.randomUUID();
    private static final UUID SCHOOL_SUBJECT_ID = UUID.randomUUID();

    private SchoolClass schoolClass;
    private Teacher teacher;
    private SchoolSubject schoolSubject;

    private final MappingService mappingService = new MappingServiceImpl();
    @MockBean private SchoolClassMapper schoolClassMapper;
    @MockBean private TeacherMapper teacherMapper;
    @MockBean private SchoolSubjectMapper schoolSubjectMapper;

    @Autowired private LessonMapper lessonMapper;

    @BeforeEach
    public void setUp() {
        schoolClass = new SchoolClass();
        teacher = new Teacher();
        schoolSubject = new SchoolSubject();
        schoolClass.setId(SCHOOL_CLASS_ID);
        teacher.setId(TEACHER_ID);
        schoolSubject.setId(SCHOOL_SUBJECT_ID);

        when(schoolClassMapper.createDestination(any(SchoolClass.class))).thenReturn(new SchoolClassDto());
        when(teacherMapper.createDestination(any(Teacher.class))).thenReturn(new TeacherDto());
        when(schoolSubjectMapper.createDestination(any(SchoolSubject.class))).thenReturn(new SchoolSubjectDto());

        when(schoolClassMapper.getPropertiesType()).thenReturn(SchoolClassDto.Properties.class);
        when(teacherMapper.getPropertiesType()).thenReturn(TeacherDto.Properties.class);
        when(schoolSubjectMapper.getPropertiesType()).thenReturn(SchoolSubjectDto.Properties.class);

        doAnswer(invocation -> {
            var entity = invocation.getArgument(0, SchoolClass.class);
            var dto = invocation.getArgument(1, SchoolClassDto.class);
            dto.setId(entity.getId());
            return null;
        }).when(schoolClassMapper).transform(any(SchoolClass.class), any(SchoolClassDto.class), any(SchoolClassDto.Properties.class));

        doAnswer(invocation -> {
            var entity = invocation.getArgument(0, Teacher.class);
            var dto = invocation.getArgument(1, TeacherDto.class);
            dto.setId(entity.getId());
            return null;
        }).when(teacherMapper).transform(any(Teacher.class), any(TeacherDto.class), any(TeacherDto.Properties.class));

        doAnswer(invocation -> {
            var entity = invocation.getArgument(0, SchoolSubject.class);
            var dto = invocation.getArgument(1, SchoolSubjectDto.class);
            dto.setId(entity.getId());
            return null;
        }).when(schoolSubjectMapper).transform(any(SchoolSubject.class), any(SchoolSubjectDto.class), any(SchoolSubjectDto.Properties.class));
    }

    @Test
    public void givenLesson_shouldMapToLessonDto() {
        var lessonId = UUID.randomUUID();
        var lesson = new Lesson();
        lesson.setId(lessonId);
        lesson.setSchoolSubject(schoolSubject);
        lesson.setStudentClass(schoolClass);
        lesson.setTeacher(teacher);

        var properties = mappingService.createProperties(LessonDto.Properties.class)
                .setIncludeSchoolSubject(true)
                .setIncludeStudentClass(true);

        var lessonDto = lessonMapper.map(lesson, properties);

        assertEquals(lessonDto.getId(), lessonId);

        assertThat(lessonDto.getStudentClass()).isNotNull();
        assertEquals(lessonDto.getStudentClass().getId(), SCHOOL_CLASS_ID);

        assertThat(lessonDto.getTeacher()).isNull();

        assertThat(lessonDto.getSchoolSubject()).isNotNull();
        assertEquals(lessonDto.getSchoolSubject().getId(), SCHOOL_SUBJECT_ID);
    }

    @Test
    public void givenNullEntity_shouldReturnNullDto() {
        var properties = mappingService.createProperties(LessonDto.Properties.class)
                .setIncludeSchoolSubject(true)
                .setIncludeStudentClass(true);
        var dto = lessonMapper.map((Lesson) null, properties);
        assertThat(dto).isNull();

    }
}
