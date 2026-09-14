package mutithreading;

public class Demo4 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Current thread is " + Thread.currentThread().getName());
        });

        // t1.start();
        // t1.start();
        t1.run();
    }

}
// can we start the thread twice ? answer no