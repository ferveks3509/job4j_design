package lambda.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", value=" + value +
                '}';
    }

    public static void main(String[] args) {
        Arrays.stream(Suit.values())
                .flatMap(suit -> Arrays.stream(Value.values())
                        .map(value -> new Card(suit, value)))
                .forEach(System.out::println);
    }
}
