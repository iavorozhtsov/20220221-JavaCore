package HomeWork_09;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class HomeWork_09 {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        Course psychology = new Course("Psychology");
        Course biology = new Course("Biology");
        Course english = new Course("English");
        Course math = new Course("Math");
        Course economy = new Course("Economy");
        Course informatic = new Course("Informatic");
        Course databases = new Course("Databases");

        List<Course> student0Coureses = new ArrayList<>();
        student0Coureses.add(biology);
        student0Coureses.add(english);
        student0Coureses.add(economy);

        List<Course> student1Coureses = new ArrayList<>();
        student1Coureses.add(psychology);
        student1Coureses.add(english);
        student1Coureses.add(biology);
        student1Coureses.add(biology);
        student1Coureses.add(biology);

        List<Course> student2Coureses = new ArrayList<>();
        student2Coureses.add(informatic);
        student2Coureses.add(math);

        List<Course> student3Coureses = new ArrayList<>();
        student3Coureses.add(informatic);
        student3Coureses.add(english);
        student3Coureses.add(math);
        student3Coureses.add(math);

        List<Course> student4Coureses = new ArrayList<>();
        student4Coureses.add(informatic);
        student4Coureses.add(english);


        students.add(new Student("Ivan"));
        students.get(0).setCourses(student0Coureses);
        students.add(new Student("Egor"));
        students.get(1).setCourses(student1Coureses);
        students.add(new Student("Maksim"));
        students.get(2).setCourses(student2Coureses);
        students.add(new Student("Gleb"));
        students.get(3).setCourses(student3Coureses);
        students.add(new Student("Roman"));
        students.get(4).setCourses(student4Coureses);


        //Задание 1
        List <Course> courses = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            courses.addAll(students.get(i).getCourses());
        }
        courses.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("***********");

        //Задание 2
        students.stream()
                .sorted((e1, e2) -> e2.getCourses().size() - e1.getCourses().size())
                .limit(3)
                .forEach((s) -> System.out.println(s.getName() + " - " + s.getCourses().size()));
        System.out.println("***********");

        //Задание 3
        students.stream()
                .filter((s) -> s.getCourses().contains(informatic))
                .forEach((s) -> System.out.println(s.getName()));

    }
}
