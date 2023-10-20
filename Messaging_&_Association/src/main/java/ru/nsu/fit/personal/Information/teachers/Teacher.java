package ru.nsu.fit.personal.Information.teachers;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.nsu.fit.courses.Course;
import ru.nsu.fit.group.Group;
import ru.nsu.fit.personal.Information.PersonalInformation;
import ru.nsu.fit.personal.Information.students.Student;
import ru.nsu.fit.rating.Rating;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Getter @Setter @FieldDefaults(level= AccessLevel.PRIVATE)
public class Teacher extends PersonalInformation {
    Set<Course> courses;
    Map<Course, Group> courseGroupMap;
    public Teacher(@NonNull String firstName, @NonNull String lastName, @NonNull String dateOfBirth) {
        super(firstName, lastName, dateOfBirth);
        courses = new HashSet<>();
        courseGroupMap = new HashMap<>();
    }

    public Teacher(@NonNull String firstName, @NonNull String lastName, @NonNull String dateOfBirth, Set<Course> courses, Map<Course, Group> courseGroupMap) {
        super(firstName, lastName, dateOfBirth);
        this.courses = courses;
        this.courseGroupMap = courseGroupMap;
    }

    public Teacher(@NonNull String firstName, @NonNull String lastName, @NonNull String dateOfBirth, Set<Course> courses) {
        super(firstName, lastName, dateOfBirth);
        this.courses = courses;
        courseGroupMap = new HashMap<>();
    }
    public Group addNewCourse(Course course, String name){
        Group group = new Group(name, new HashSet<>(), "");
        courses.add(course);
        courseGroupMap.put(course, group);
        return group;
    }

    public boolean addStudent(Course course, Student student){
        if(courses.contains(course) && !courseGroupMap.get(course).getStudentSet().contains(student)) {
            student.addCourse(course, this);
            return courseGroupMap.get(course).getStudentSet().add(student);
        }
        else return false;
    }
    public boolean removeStudent(Course course, Student student){
        if(courses.contains(course) && courseGroupMap.get(course).getStudentSet().contains(student))
            return courseGroupMap.get(course).getStudentSet().remove(student);
        else return false;
    }
    public boolean sendHomeWorkStudents(Course course, String homework) {
        Set<Student> set = courseGroupMap.get(course).getStudentSet();
        return set.stream()
                .map(student -> student.addHomework(course, this, homework))
                .reduce(true, (a, b) -> a && b);
    }
    public boolean setFinalGradeStudent(Course course, Student student, Rating rating) {
        if(courses.contains(course) && courseGroupMap.get(course).getStudentSet().contains(student)) {
            return student.setFinalGrade(course, this, rating);
        }
        else return false;
    }
    public boolean addRatingStudent(Course course, Student student, Rating rating) {
        if(courses.contains(course) && courseGroupMap.get(course).getStudentSet().contains(student))
            return student.addRating(course, this, rating);
        else return false;
    }
    public boolean removeRatingStudent(Course course, Student student, Rating rating) {
        if(courses.contains(course) && courseGroupMap.get(course).getStudentSet().contains(student))
            return student.removeRating(course, this, rating);
        else return false;
    }
    public boolean removeAllRatingStudent(Course course, Student student, Rating rating) {
        if(courses.contains(course) && courseGroupMap.get(course).getStudentSet().contains(student))
            return student.removeAllRating(course, this, rating);
        else return false;
    }
    public Group getGroup(Course course) {
        if(courses.contains(course))
            return courseGroupMap.get(course);
        else return null;
    }
}
