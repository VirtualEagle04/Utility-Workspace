package fuerzabruta;

public class NumberSearch {
    private static volatile boolean found = false;
    private static final int targetNumber = 42; // Change this to your target number

    public static void main(String[] args) {
        Thread upThread = new Thread(() -> {
            searchUp();
        });
        

        Thread downThread = new Thread(() -> {
            searchDown();
        });

        upThread.start();
        downThread.start();

        try {
            upThread.join();
            downThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void searchUp() {
        for (int i = 0; i <= Integer.MAX_VALUE; i++) {
            if (i == targetNumber) {
                found = true;
                System.out.println("Number found by the up thread: " + i);
                break;
            }
            if (found) {
                System.out.println("Up thread stopping...");
                break;
            }
        }
    }

    private static void searchDown() {
        for (int i = 0; i >= Integer.MIN_VALUE; i--) {
            if (i == targetNumber) {
                found = true;
                System.out.println("Number found by the down thread: " + i);
                break;
            }
            if (found) {
                System.out.println("Down thread stopping...");
                break;
            }
        }
    }
}
