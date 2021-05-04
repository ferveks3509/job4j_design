package test;

import java.util.List;

import java.util.HashMap;
import java.util.Objects;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Info rsl = new Info();
        HashMap<Integer, String> map = new HashMap<>();
        for (User user : previous) {
            map.put(user.id, user.name);
        }
        for (User user : current) {
            if (map.containsKey(user.id)) {
                if (!Objects.equals(map.get(user.id), user.name)) {
                    rsl.changed++;
                }
                map.remove(user.id);
            } else  {
                rsl.added++;
            }
        }
        rsl.deleted = map.size();
        return rsl;
    }

    public static class User {
        int id;
        String name;
    }

    public static class Info {
        int added;
        int changed;
        int deleted;
    }
}
