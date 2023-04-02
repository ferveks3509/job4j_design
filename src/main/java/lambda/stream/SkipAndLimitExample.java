package lambda.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SkipAndLimitExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        List<String> rslFirst = strings
                .stream()
                .skip(2)
                .collect(Collectors.toList());
        System.out.println(rslFirst);

        List<String> rslSecond = strings
                .stream()
                .skip(2)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(rslSecond);

        List<Integer> list = Arrays.asList(4, 5, 1, 3, 2);
        Optional<Integer> minEl = list.stream()
                        .min(Comparator.naturalOrder());
        System.out.println(minEl.get());
    }
}
