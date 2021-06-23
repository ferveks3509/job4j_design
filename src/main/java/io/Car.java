package io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.internal.$Gson$Preconditions;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;
import java.util.*;

//@XmlRootElement(name = "car")
//@XmlAccessorType(XmlAccessType.FIELD)
public class Car {
    //@XmlAttribute
    private boolean have;
    //@XmlAttribute
    private double engine;
    //@XmlAttribute
    private String mark;
    private CarColor carColor;
    private List<String> equipment;

    public Car(boolean have, double engine, String mark, CarColor carColor, List<String> equipment) {
        this.have = have;
        this.engine = engine;
        this.mark = mark;
        this.carColor = carColor;
        this.equipment = equipment;
    }

    public Car() {

    }

    public boolean isHave() {
        return have;
    }

    public void setHave(boolean have) {
        this.have = have;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public CarColor getCarColor() {
        return carColor;
    }

    public void setCarColor(CarColor carColor) {
        this.carColor = carColor;
    }

    public List<String> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<String> equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return "Car{" +
                "have=" + have +
                ", engine=" + engine +
                ", mark='" + mark + '\'' +
                ", carColor=" + carColor +
                ", equipment=" + equipment +
                '}';
    }

    public static void main(String[] args) throws Exception {
        /*
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(car));

        String carJason =
                        "{"
                        + "\"have\":false,"
                        + "\"engine\":1.9,"
                        + "\"mark\":\"priora\","
                        + "\"CarColor\":"
                            + "{"
                                + "\"color\":\"white\""
                            + "},"
                        + "\"equipment\":"
                            + "[\"full\"]"
                        + "}";
        final Car carMod = gson.fromJson(carJason, Car.class);
        System.out.println(carMod);

        JAXBContext context = JAXBContext.newInstance(Car.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(car, writer);
            String rsl = writer.getBuffer().toString();
            System.out.println(rsl);
        } catch (Exception e) {
        }
         */
        List<String> q = List.of("full");
        Car car = new Car(true, 1.6, "priora", new CarColor("white"), q);
        JSONObject jsonCarColor = new JSONObject("{\"color\":\"white\"}");
        List<String> euq = new ArrayList<>();
        euq.add("full");
        JSONArray jsonArray = new JSONArray(euq);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("have", car.have);
        jsonObject.put("engine", car.engine);
        jsonObject.put("mark", car.mark);
        jsonObject.put("carColor", jsonCarColor);
        jsonObject.put("equipment", jsonArray);

        System.out.println(jsonObject.toString());

        System.out.println(new JSONObject(car).toString());
    }
}

