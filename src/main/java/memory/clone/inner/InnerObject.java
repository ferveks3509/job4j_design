package memory.clone.inner;

public class InnerObject implements Cloneable{
    int num;

    @Override
    protected InnerObject clone() throws CloneNotSupportedException {
        return (InnerObject) super.clone();
    }
}
