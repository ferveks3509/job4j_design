package io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.$Gson$Preconditions;

import java.util.Arrays;

public class Car {
    private boolean have;
    private double engine;
    private String mark;
    private CarColor carColor;
    private String[] equipment;

    public Car(boolean have, double engine, String mark, CarColor carColor, String[] equipment) {
        this.have = have;
        this.engine = engine;
        this.mark = mark;
        this.carColor = carColor;
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return "Car{" +
                "have=" + have +
                ", engine=" + engine +
                ", mark='" + mark + '\'' +
                ", carColor=" + carColor +
                ", equipment=" + Arrays.toString(equipment) +
                '}';
    }

    public static void main(String[] args) {
        Car car = new Car(true, 1.6, "priora", new CarColor("white"), new String[]{"full"});
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(car));

        String carJason =
                        "{"
                        + "\"have\":false,"
                        + "\"engine\":1.9,"
                        + "\"mark\":\"priora\","
                        + "\"CarColor\":"
                            + "{"
                                + "\"color\":\"white\","
                            + "},"
                        + "\"equipment\":"
                            + "[\"full\"]"
                        + "}";
        final Car carMod = gson.fromJson(carJason, Car.class);
        System.out.println(carMod);

    }
}
