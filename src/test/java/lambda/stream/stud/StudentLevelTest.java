package lambda.stream.stud;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StudentLevelTest {

    @Test
    public void whenSorted() {
        List<Student> input = new ArrayList<>();
        input.add(new Student(28, "Masha"));
        input.add(new Student(128, "Pety"));
        List<Student> expected = List.of(
                new Student(28, "Masha"),
                new Student(128, "Pety")
        );
        assertArrayEquals(StudentLevel.levelOf(input, 20).toArray(), expected.toArray());
    }

    @Test
    public void whenOnlyNull() {
        List<Student> input = new ArrayList<>();
        input.add(null);
        List<Student> expected = List.of();
        assertArrayEquals(StudentLevel.levelOf(input, 20).toArray(), expected.toArray());
    }

    @Test
    public void whenHasNull() {
        List<Student> input = new ArrayList<>();
        input.add(null);
        input.add(new Student(28, "Pety"));
        List<Student> expected = List.of(new Student(28, "Pety"));
        assertArrayEquals(StudentLevel.levelOf(input, 20).toArray(), expected.toArray());
    }
}