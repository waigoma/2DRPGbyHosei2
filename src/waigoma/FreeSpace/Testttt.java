package waigoma.FreeSpace;

public class Testttt extends Thread {
    public static void main(String[] args) throws InterruptedException {
        Testttt t = new Testttt();
        t.start();
        sleep(1000);
        System.out.println("a");
    }

    @Override
    public void run() {
        System.out.println("hi");
    }
}
