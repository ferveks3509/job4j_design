package lambda.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ForEachExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Один", "два", "три");
        words.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        List<StringBuilder> names = Arrays.asList(
                new StringBuilder("Михаил"), new StringBuilder("Иван"), new StringBuilder("Елена"));
        List<StringBuilder> editedNames = names
                .stream()
                .peek((el) -> el.append(" (Ученик Job4j)"))
                .sorted()
                .collect(Collectors.toList());
        System.out.println(editedNames);
    }
}
