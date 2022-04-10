package HomeWork_09;

import java.util.List;

public class Student {
    String name;
    List <Course> courses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Student(String name) {
        this.name = name;
    }
}
