package volatile_task1;

public class Toy extends Thread {

    public static volatile boolean tumbler;

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                if (tumbler) {
                    System.out.println(Thread.currentThread().getName() + ": Tumbler off");
                    sleep(2000);
                    tumbler = false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
