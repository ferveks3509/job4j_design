package lambda.stream;

import java.util.Arrays;
import java.util.List;

public class MatchStream {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        boolean rsl = strings
                .stream()
                .noneMatch("Шесть"::contains);
        System.out.println(rsl);

        boolean rslSecond = strings
                .stream()
                .anyMatch(e -> e.endsWith("ь"));
        System.out.println(rslSecond);

        boolean rslThird = strings
                .stream()
                .anyMatch(e -> e.length() >= 3);
        System.out.println(rslThird);
    }
}
