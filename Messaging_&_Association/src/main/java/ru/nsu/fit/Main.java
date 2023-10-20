package ru.nsu.fit;

import ru.nsu.fit.courses.Course;
import ru.nsu.fit.group.Group;
import ru.nsu.fit.personal.Information.students.Student;
import ru.nsu.fit.personal.Information.teachers.Teacher;
import ru.nsu.fit.rating.Rating;

import java.util.HashSet;

import static org.icecream.IceCream.ic;

public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("John", "Doe", "01.01.1990");
        Course course = new Course("Math", 3, new HashSet<>());
        Student student = new Student("Alice", "Smith", "02.02.2000", 12345);
        Student student1 = new Student("Alice", "Smith", "02.02.2000", 12345);
        ic(teacher.addStudent(course, student));
        ic(teacher.addStudent(course, student1));

        ic(teacher.removeStudent(course, student));
        ic(teacher.addStudent(course, student));
        ic(teacher.sendHomeWorkStudents(course, "Complete the assignment"));
        ic(teacher.setFinalGradeStudent(course, student, Rating.FIVE));
    }
}
