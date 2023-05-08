package concurrent;

public class Wget {
    public static void main(String[] args) {
        Thread th = new Thread(
                () -> {
                    try {
                        int i = 0;
                        while (i < 100) {
                            i++;
                            Thread.sleep(500);
                            System.out.print("\rLoading: " + i + "%");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );
        th.start();
        System.out.println("new commit");
        System.out.println("new commit");
        System.out.println("new commit");
    }
}
