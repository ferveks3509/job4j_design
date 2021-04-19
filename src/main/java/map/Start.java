package map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Start {
    public static void main(String[] args) {
        User first = new User("First", 1, new GregorianCalendar(2021, 3, 12));
        User second = new User("First", 1, new GregorianCalendar(2021, 3, 12));

        Map<User, Object> data = new HashMap<>();
        data.put(first, new Object());
        data.put(second, new Object());
        System.out.println(data.size());
        System.out.println(first.hashCode() / 16);
        System.out.println(second.hashCode() / 16);
    }
}
