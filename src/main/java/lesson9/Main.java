package lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Anna", Arrays.asList(new Course("Chemistry"), new Course("History"),
                new Course("Literature"))));
        students.add(new Student("Irina", Arrays.asList(new Course("Math"), new Course("Geography"),
                new Course("Sociology"))));
        students.add(new Student("Vasilisa", Arrays.asList(new Course("Physics"), new Course("Biology"),
                new Course("Math"), new Course("Economy"))));
        students.add(new Student("Alexey", Arrays.asList(new Course("Physics"), new Course("Math"),
                new Course("Economy"), new Course("Biology"), new Course("Computer science"))));

        System.out.println(students.stream()
                .map(Student::getCourses)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet()));


        System.out.println(students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(2)
                .collect(Collectors.toList()));


        Course course = new Course("Testing");
        System.out.println(students.stream()
                .filter(s -> s.getCourses().contains(course))
                .collect(Collectors.toList()));
    }
}
