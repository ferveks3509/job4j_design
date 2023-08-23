package designPatterns.strategy;

public class Triangle implements Strategy {
    @Override
    public String print() {
        String ln = System.lineSeparator();
        return    "   ^    " + ln
                + " /   \\ " + ln
                + "/_____\\" + ln;
    }
}
