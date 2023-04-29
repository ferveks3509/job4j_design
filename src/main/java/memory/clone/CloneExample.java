package memory.clone;

public class CloneExample {
    int num;

    public static void main(String[] args) {
        CloneExample obj1 = new CloneExample();
        obj1.num = 5;
        CloneExample obj2 = obj1;
        obj2.num = 10;
        System.out.println(obj1.num);
    }
}
