package lambda.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-1, 2, 3, 4, -1, -2);
        List<Integer> positive = numbers.stream()
                .filter(n -> n > 0)
                .collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}
