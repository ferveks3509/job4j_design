package designPatterns.builder;

import java.time.LocalDate;

/**
 * Строитель - это порождающий шаблон проектирования, который позволяет создавать сложные объекты пошагово
 *
 * 1. Позволяет создавать объекты пошагово;
 * 2. Позволяет использовать один и тот же код для создания различных объектов - если использовать не класс Builder, а interface
 * 3. Сложный код сборки объекта от основной бизнес логики будет изолирован.
 *
 * шаблон проектирования используется для построения Stream
 */
public class Car {
    private String brand;

    private String model;

    private LocalDate created;

    private double volume;

    private String color;

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", created=" + created +
                ", volume=" + volume +
                ", color='" + color + '\'' +
                '}';
    }

    static class Builder {
        private String brand;
        private String model;
        private LocalDate created;
        private double volume;
        private String color;

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildCreated(LocalDate created) {
            this.created = created;
            return this;
        }

        Builder buildVolume(double volume) {
            this.volume = volume;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.brand = brand;
            car.color = color;
            car.model = model;
            car.created = created;
            car.volume = volume;
            return car;
        }
    }

    public static void main(String[] args) {
        Car car = new Builder()
                .buildBrand("Toyota")
                .buildModel("Camry")
                .buildCreated(LocalDate.of(2021, 6, 1))
                .buildVolume(2.5)
                .buildColor("Red")
                .build();
        System.out.println(car);
    }
}
