package designPatterns.strategy;

public class Any implements Strategy {
    @Override
    public String print() {
        return "any";
    }
}
