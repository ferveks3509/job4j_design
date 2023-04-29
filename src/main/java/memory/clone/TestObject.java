package memory.clone;

public class TestObject implements Cloneable {
    int num;

    @Override
    protected TestObject clone() throws CloneNotSupportedException {
        return (TestObject) super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        TestObject o1 = new TestObject();
        o1.num = 5;
        TestObject o2 = o1.clone();
        o2.num = 10;
        System.out.println(o1.num);
        System.out.println(o2.num);
    }
}
