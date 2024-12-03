package pl.pwr.ite.bd2.client.web.mapper;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.GradeDto;
import pl.pwr.ite.bd2.mapping.MapperBase;
import pl.pwr.ite.bd2.model.entity.Grade;
import pl.pwr.ite.bd2.model.entity.SchoolSubject;
import pl.pwr.ite.bd2.model.entity.Student;
import pl.pwr.ite.bd2.model.entity.Teacher;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class GradeMapper extends MapperBase<Grade, GradeDto, GradeDto.Properties> {

    // Podajemy tutaj pola z klasy Example
    private Integer numberGrade;
    private String description;
    private LocalDateTime date;
    private Integer weight;
    private Student student;
    private SchoolSubject schoolSubject;
    private Teacher teacher;
    @Override
    public void transform(Grade source, GradeDto destination, GradeDto.Properties properties) {
//        destination.setStreet(source.getStreet());

    }
}
