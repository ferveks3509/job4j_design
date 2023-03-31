package lambda.function;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.List;
import java.util.function.Predicate;


public class SearchFolderTest {

    @Test
    public void whenFilterSize() {
        List<Folder> list = List.of(
                new Folder("fix", 110),
                new Folder("bug", 75),
                new Folder("bug", 90)
        );
        List<Folder> expected = List.of(new Folder("fix", 110));
        Predicate<Folder> pred = f -> f.getSize() > 100;
        List<Folder> rsl = SearchFolder.filter(list, pred);
        assertEquals(rsl.get(0), expected.get(0));
    }

    @Test
    public void whenFilterName() {
        List<Folder> list = List.of(
                new Folder("fix", 110),
                new Folder("bug", 75),
                new Folder("bug", 90)
        );
        List<Folder> expected = List.of(
                new Folder("bug", 75),
                new Folder("bug", 90)
        );
        Predicate<Folder> pred = f -> f.getName().contains("bug");
        List<Folder> rsl = SearchFolder.filter(list, pred);
        assertEquals(rsl.get(0), expected.get(0));
    }
}