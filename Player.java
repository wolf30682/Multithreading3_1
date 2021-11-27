package volatile_task1;

public class Player extends Thread {

    @Override
    public void run() {
        int count = 0;
        while (!Thread.interrupted()) {
            if (!Toy.tumbler) {
                if (count < 10) {
                    try {
                        System.out.println(Thread.currentThread().getName() + ": Tumbler on");
                        Toy.tumbler = true;
                        sleep(1000);
                    } catch (InterruptedException err) {
                        err.printStackTrace();
                    }
                } else {
                    break;
                }
                count++;
            }
        }
    }
}
