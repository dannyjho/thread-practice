package thread_pool_demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Work implements Runnable {
    private int id;

    public Work(int id) {
        this.id = id;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() +
                " Begins Work " + id);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +
                " Ends Work " + id);
    }
}

public class ThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(new Work(1));
        executorService.execute(new Work(2));
        executorService.execute(new Work(3));

        // anonymous inner class
        executorService.execute(() -> System.out.println(Thread.currentThread().getName() +
                " Begins Work in anonymous inner class."));
    }
}

