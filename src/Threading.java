public class Threading implements Runnable {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("This is message #" + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Threading());
        t1.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
