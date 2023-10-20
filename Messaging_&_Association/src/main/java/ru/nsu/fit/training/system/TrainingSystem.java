package ru.nsu.fit.training.system;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.nsu.fit.courses.Course;
import ru.nsu.fit.group.Group;
import ru.nsu.fit.personal.Information.PersonalInformation;
import ru.nsu.fit.personal.Information.students.Student;
import ru.nsu.fit.personal.Information.teachers.Teacher;


import java.util.HashSet;
import java.util.Set;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @FieldDefaults(level= AccessLevel.PRIVATE)
public class TrainingSystem {
    Set<Group> groupList = new HashSet<>();
    Set<Course> courseList = new HashSet<>();
    Set<Student> studentList = new HashSet<>();
    Set<Teacher> teacherList = new HashSet<>();
    public boolean addTeacher(Teacher c) {
        return teacherList.add(c);
    }
    public boolean removeTeacher(Teacher c) {
        return teacherList.remove(c);
    }
    public boolean addCourse(Course c) {
        return courseList.add(c);
    }
    public boolean removeCourse(Course c) {
        return courseList.remove(c);
    }

    public boolean addGroup(Group c) {
        return groupList.add(c);
    }
    public boolean removeGroup(Group c) {
        return groupList.remove(c);
    }
    public boolean addStudent(Student c) {
        return studentList.add(c);
    }
    public boolean removeStudent(Student c) {
        return studentList.remove(c);
    }

    public boolean newGroupStudent(Student student, Course course, Teacher oldTeacher, Teacher newTeacher){
         if(oldTeacher.getGroup(course).getStudentSet().contains(student) && newTeacher.getGroup(course) != null){
             oldTeacher.removeStudent(course, student);
             return newTeacher.addStudent(course, student);
         }
         return false;
    }
    public void sendNewSchedule(Group group, String str){
        group.setSchedule(str);
    }
    public void setNewConfig(PersonalInformation personalInformation, String dateOfBirth, String firstName, String lastName){
        personalInformation.setDateOfBirth(dateOfBirth);
        personalInformation.setLastName(lastName);
        personalInformation.setFirstName(firstName);
    }
}
