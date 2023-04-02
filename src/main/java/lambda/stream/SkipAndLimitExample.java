package lambda.stream;

import java.util.Arrays;
import java.util.List;
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


    }
}
