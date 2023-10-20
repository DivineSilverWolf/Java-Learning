package ru.nsu.fit.group;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.nsu.fit.personal.Information.students.Student;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @FieldDefaults(level= AccessLevel.PRIVATE)
public class Group {
    String name;
    Set<Student> studentSet = new HashSet<>();
    String schedule;
    public boolean addStudent(Student student) {
        return studentSet.add(student);
    }

    public boolean removeStudent(Student student) {
        return studentSet.remove(student);
    }
}