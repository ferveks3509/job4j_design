package Generic;

public class Predator extends Animal {
    private String type;

    public Predator(String type, String type1) {
        super(type);
        this.type = type1;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Predator{" +
                "type='" + type + '\'' +
                '}';
    }
}
