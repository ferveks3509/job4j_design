package algo;

public class TurnBack {
    public static int[] back(int[] array) {
        for (int index = 0; index < array.length / 2; index++) {
            int temp = array[index];
            array[index] = array[array.length - index - 1];
            array[array.length - index - 1] = temp;
            System.out.println("hello");
        }
        return array;
    }
}

