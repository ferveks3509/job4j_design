package designPatterns.strategy;

public class Context {

    public void draw(Strategy strategy) {
        System.out.print(strategy.print());
    }

    public static void main(String[] args) {
        Context context = new Context();
        Strategy tr = new Triangle();
        Strategy words = new Words();
        context.draw(tr);
        context.draw(words);
    }
}
