
public class Demo {
    public static void main(String[] args) {

        MyThread mt = new MyThread();
        mt.start();
    }
}

// Thread classExtended
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("thread is running");
    }
}
// t1.start jvm asks os to create a new thread thread get stack/pc space
// Thread execute run method
