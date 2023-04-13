package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader in = new BufferedReader(
                new FileReader(this.path))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                if (!line.contains("#") && !line.isEmpty()) {
                    String[] key = line.split("=");
                    values.put(key[0], key[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
      Config config = new Config("data/app.properties");
      config.load();
      for (String key : config.values.keySet()) {
          String value = config.values.get(key);
          System.out.println("Key: " + key + " = " + "value: "+ value);
      }
    }
}
