package memory;

public class Example {

    public void action(Object obj) {
        String str = obj.toString();
        System.out.println(str);
    }

    public static void main(String[] args) {
        int x = 0;
        Object obj = new Object();
        Example example = new Example();
        example.action(obj);
    }
}
