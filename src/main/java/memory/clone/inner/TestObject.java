package memory.clone.inner;

public class TestObject implements Cloneable {
    int num;
    InnerObject innerObj;

    @Override
    protected TestObject clone() throws CloneNotSupportedException {
        TestObject testObj = (TestObject) super.clone();
        testObj.innerObj = innerObj.clone();
        return testObj;
    }
}
