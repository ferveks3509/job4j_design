package Generic;

import java.util.ArrayList;
import java.util.List;

public class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        this.mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int i = index(id);
        if (i != -1) {
            mem.set(i, model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        int i = index(id);
        if (i != -1) {
            mem.remove(i);
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        int i = index(id);
        if (i != -1) {
            return mem.get(i);
        }
        return null;
    }

    private int index(String id) {
        int index = -1;
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
