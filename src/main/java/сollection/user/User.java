package сollection.user;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Objects;

public class User {
    private String name;
    private int children;
    private Calendar birthDay;

    public User(String name, int children, Calendar birthDay) {
        this.name = name;
        this.children = children;
        this.birthDay = birthDay;
    }

    public static void main(String[] args) {
        HashMap<User, Object> map = new HashMap<>(16);
        Calendar calendar = Calendar.getInstance();
        User first = new User("ilya", 0, calendar);
        User second = new User("ilya", 0, calendar);
        int hashCodeFirst = first.hashCode();
        int hashFirst = hashCodeFirst ^ (hashCodeFirst >>> 16);
        int bucketFirst = hashFirst & 15;

        int hashCodeSecond = second.hashCode();
        int hashSecond = hashCodeSecond ^ (hashCodeFirst >>> 16);
        int bucketSecond = hashSecond & 15;
        map.put(first, new Object());
        map.put(second, new Object());
        System.out.printf("First - хешкод: %s, хэш: %s, бакет: %s",
                hashCodeFirst, hashFirst, bucketFirst);
        System.out.println();
        System.out.printf("First - хешкод: %s, хэш: %s, бакет: %s",
                hashCodeSecond, hashSecond, bucketSecond);
        System.out.println();
        System.out.println(map.get(first).equals(map.get(second)));
    }
}
