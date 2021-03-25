package Generic;

public class Tiger extends Predator {
    private String weight;

    public Tiger(String type, String type1, String weight) {
        super(type, type1);
        this.weight = weight;
    }

    public String getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "weight='" + weight + '\'' +
                '}';
    }
}