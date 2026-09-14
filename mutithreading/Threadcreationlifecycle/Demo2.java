
public class Demo2 {
    public static void main(String[] args) {
        Mytask task = new Mytask();
        Thread t1 = new Thread(task);
        t1.start();
    }

}

class Mytask implements Runnable {
    @Override
    public void run() {
        System.out.println("task thread is running");
    }
}
