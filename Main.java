package volatile_task1;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        final Thread toyThread = new Thread(null, new Toy(), "Toy");
        toyThread.start();

        final Thread playerThread = new Thread(null, new Player(), "Player");
        playerThread.start();


        playerThread.join();

        if (!playerThread.isAlive()) {
            System.out.println(playerThread.getName() + " is finished");
            toyThread.interrupt();
        }

        toyThread.join(1000);

        if (!toyThread.isAlive()) {
            System.out.println("ToyThread is finished");
        }
    }
}
