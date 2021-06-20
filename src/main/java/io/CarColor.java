package io;

import java.io.*;

public class CarColor {
    private String color;

    public CarColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "CarColor{" +
                "color='" + color + '\'' +
                '}';
    }
}
