package algo;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl = 0;
        int minLength = Math.min(o1.length(), o2.length());
        for (int i = 0; i < minLength; i++) {
            rsl = Character.compare(o1.charAt(i), o2.charAt(i));
            if (rsl != 0)
                break;
        }
        return rsl != 0 ? rsl : Integer.compare(o1.length(), o2.length());
    }
}
