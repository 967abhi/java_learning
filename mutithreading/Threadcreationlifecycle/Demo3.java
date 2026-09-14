
public class Demo3 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getName());
        // System.out.println(Thread.currentThread().getPriority());
        // System.out.println(Thread.currentThread().getState());
        // System.out.println(Thread.currentThread().isDaemon());
        // System.out.println(Thread.currentThread().isAlive());
        Thread T1 = new Thread(() -> {
            System.out.println("thread is running");

        });
        T1.start();
        System.out.println(T1.getId());
        System.out.println(T1.getName());
    }

}
// TThread Id and thread name