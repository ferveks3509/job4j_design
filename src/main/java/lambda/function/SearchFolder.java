package lambda.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFolder {
    public static List<Folder> filterSize(List<Folder> list) {
        List<Folder> rsl = new ArrayList<>();
        for (Folder f : list) {
            if (f.getSize() > 100) {
                rsl.add(f);
            }
        }
        return rsl;
    }

    public static List<Folder> filterName(List<Folder> list) {
        List<Folder> rsl = new ArrayList<>();
        for (Folder f : list) {
            if (f.getName().contains("bug")) {
                rsl.add(f);
            }
        }
        return rsl;
    }

    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        List<Folder> result = new ArrayList<>();
        for (Folder el : list) {
            if (pred.test(el))
                result.add(el);
        }
        return result;
    }
}
