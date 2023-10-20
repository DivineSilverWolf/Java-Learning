package ru.nsu.fit.courses;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.nsu.fit.group.Group;
import ru.nsu.fit.personal.Information.teachers.Teacher;

import java.util.Set;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @FieldDefaults(level= AccessLevel.PRIVATE)
public class Course {
    String description;
    int duration;
    Set<Teacher> teachers;

    public String analyzeRatingsForThisCourse() {
        StringBuilder sb = new StringBuilder();

        teachers.forEach(teacher -> {
            Group group = teacher.getGroup(this);

            group.getStudentSet().forEach(student -> student.getRatingList(this, teacher).forEach(rating -> sb.append(rating).append(" ")));
        });

        return sb.length() == 0 ? "No rating found" : sb.toString();
    }


}
