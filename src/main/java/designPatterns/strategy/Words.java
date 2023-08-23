package designPatterns.strategy;

public class Words implements Strategy{
    @Override
    public String print() {
        return "Hello world!";
    }
}
