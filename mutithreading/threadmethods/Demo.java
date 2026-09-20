package mutithreading.threadmethods;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Main thread Start");
        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {

        }
        System.out.println("Main thread END");
    }
}

/// Thread.sleep
// It is static method which is used to pause the thread for a specific time
/// period
// It can throw Interruptedexception
// So always we use in try catch block
// Thread.sleep(milliseconds)->Timed_WAITING RUNNABLE->Timed_WAITING->RUNNABLE