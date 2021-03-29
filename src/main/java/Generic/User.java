package Generic;

public class User extends Base {
    private String id;

    public User(String id, String id1) {
        super(id);
        this.id = id1;
    }

    @Override
    public String getId() {
        return id;
    }
}
