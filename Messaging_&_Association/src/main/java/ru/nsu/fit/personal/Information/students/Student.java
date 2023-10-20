package ru.nsu.fit.personal.Information.students;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.nsu.fit.courses.Course;
import ru.nsu.fit.personal.Information.PersonalInformation;
import ru.nsu.fit.personal.Information.teachers.Teacher;
import ru.nsu.fit.rating.Rating;

import java.util.*;

@FieldDefaults(level= AccessLevel.PRIVATE)
public class Student extends PersonalInformation {
    @Getter @Setter @NonNull int studentIdNumber;

    public Student(@NonNull String firstName, @NonNull String lastName, @NonNull String dateOfBirth, @NonNull int studentIdNumber) {
        super(firstName, lastName, dateOfBirth);
        this.studentIdNumber = studentIdNumber;
    }
    // StudentInfo - композиция
    @Getter @Setter @AllArgsConstructor @FieldDefaults(level= AccessLevel.PRIVATE)
    private static class StudentInfo{
        Course studentCourse;
        Teacher teacher;
        List<Rating> ratings;
        Rating finalGrade;
        Set<String> homeworkSet;
    }
    final Set<StudentInfo> studentInfoSet = new HashSet<>();

    public void addCourse(Course course, Teacher teacher){
        studentInfoSet.add(new StudentInfo(course, teacher, new ArrayList<>(), Rating.ONE, new HashSet<>()));
    }
    public List<Rating> getRatingList(Course course, Teacher teacher) {
        Optional<StudentInfo> studentOpt = studentInfoSet.stream()
                .filter(info -> info.getStudentCourse().equals(course))
                .filter(info -> info.getTeacher().equals(teacher))
                .findFirst();

        return studentOpt.map(StudentInfo::getRatings).orElse(null);
    }
    public boolean addRating(Course course, Teacher teacher, Rating rating) {
        Optional<StudentInfo> studentOpt = studentInfoSet.stream()
                .filter(info -> info.getStudentCourse().equals(course))
                .filter(info -> info.getTeacher().equals(teacher))
                .findFirst();

        if (studentOpt.isPresent()) {
            studentOpt.get().getRatings().add(rating);
            return true;
        }

        return false;
    }
    public boolean addHomework(Course course, Teacher teacher, String homework) {
        Optional<StudentInfo> studentOpt = studentInfoSet.stream()
                .filter(info -> info.getStudentCourse().equals(course))
                .filter(info -> info.getTeacher().equals(teacher))
                .findFirst();
        return studentOpt.map(studentInfo -> studentInfo.getHomeworkSet().add(homework)).orElse(false);
    }
    public Set<String> getHomeworks(Course course, Teacher teacher) {
        Optional<StudentInfo> studentOpt = studentInfoSet.stream()
                .filter(info -> info.getStudentCourse().equals(course))
                .filter(info -> info.getTeacher().equals(teacher))
                .findFirst();
        return studentOpt.map(StudentInfo::getHomeworkSet).orElse(Collections.emptySet());
    }

    public boolean setFinalGrade(Course course, Teacher teacher, Rating finalGrade) {
        Optional<StudentInfo> studentOpt = studentInfoSet.stream()
                .filter(info -> info.getStudentCourse().equals(course))
                .filter(info -> info.getTeacher().equals(teacher))
                .findFirst();

        if (studentOpt.isPresent()) {
            studentOpt.get().setFinalGrade(finalGrade);
            return true;
        }
        return false;
    }

    public boolean removeRating(Course course, Teacher teacher, Rating rating) {
        Optional<StudentInfo> studentOpt = studentInfoSet.stream()
                .filter(info -> info.getStudentCourse().equals(course))
                .filter(info -> info.getTeacher().equals(teacher))
                .findFirst();

        if (studentOpt.isPresent()) {
            studentOpt.get().getRatings().remove(rating);
            return true;
        }

        return false;
    }
    public boolean removeAllRating(Course course, Teacher teacher, Rating rating) {
        Optional<StudentInfo> studentOpt = studentInfoSet.stream()
                .filter(info -> info.getStudentCourse().equals(course))
                .filter(info -> info.getTeacher().equals(teacher))
                .findFirst();

        if (studentOpt.isPresent()) {
            studentOpt.get().getRatings().removeIf(r -> r.equals(rating));
            return true;
        }

        return false;
    }
}
