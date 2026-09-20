package mutithreading.problemsinmultithreading;

public class Demo1 {
    static volatile boolean flag = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                flag = true;
                System.out.println("thread 1 finished");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            while (!flag) {
                System.out.println("Thread 2 Running");
            }
            System.out.println("thread 2 finished");
        });
        t1.start();
        t2.start();

    }
}
