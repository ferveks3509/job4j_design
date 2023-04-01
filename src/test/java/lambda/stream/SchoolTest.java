package lambda.stream;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SchoolTest {

    @Test
    public void whenCollectClassA() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(40, "Surname4"),
                new Student(50, "Surname5"),
                new Student(70, "Surname7"),
                new Student(90, "Surname9")
        );
        School school = new School();
        Predicate<Student> predicate = person -> person.getScore() >= 70 && person.getScore() <= 100;
        List<Student> result = school.collect(students, predicate);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(70, "Surname7"));
        expected.add(new Student(90, "Surname9"));
        assertEquals(result.get(0).getSurname(),"Surname7");
        assertEquals(result.get(1).getSurname(),"Surname9");
    }

    @Test
    public void whenCollectClassB() {
        List<Student> students = List.of(
                new Student(20, "Surname2"),
                new Student(30, "Surname3"),
                new Student(50, "Surname5"),
                new Student(60, "Surname6"),
                new Student(80, "Surname8")
        );
        School school = new School();
        Predicate<Student> predicate = person -> person.getScore() >= 50 && person.getScore() <= 70;
        List<Student> result = school.collect(students, predicate);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(50, "Surname5"));
        expected.add(new Student(60, "Surname6"));
        assertEquals(result.get(0).getSurname(),"Surname5");
        assertEquals(result.get(1).getSurname(),"Surname6");
    }

    @Test
    public void whenCollectClassV() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(30, "Surname3"),
                new Student(40, "Surname4"),
                new Student(60, "Surname6"),
                new Student(90, "Surname9")
        );
        School school = new School();
        Predicate<Student> predicate = person -> person.getScore() >= 0 && person.getScore() <= 50;
        List<Student> result = school.collect(students, predicate);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(10, "Surname1"));
        expected.add(new Student(30, "Surname3"));
        expected.add(new Student(40, "Surname4"));
        assertEquals(result.get(0).getSurname(),"Surname1");
        assertEquals(result.get(1).getSurname(),"Surname3");
        assertEquals(result.get(2).getSurname(),"Surname4");
    }
}