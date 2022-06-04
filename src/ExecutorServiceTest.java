import java.util.concurrent.*;
import java.util.function.BiConsumer;

public class ExecutorServiceTest {

    public static void main(String[] args) throws InterruptedException {

        PermitController permitController = new PermitController(500);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        while (true) {
            for (int i = 0; i < 100; i++) {
                permitController.acquire(5);
                doSomething(i, executorService, permitController);
            }
        }
    }

    static void doSomething(int threadID, ExecutorService executorService, PermitController permitController) {
        CompletableFuture.runAsync(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        howToDo(threadID);

                    }
                }, executorService)
                .whenComplete(new BiConsumer<Void, Throwable>() {
                    @Override
                    public void accept(Void result, Throwable exception) {
                        permitController.release(5);
                    }
                });
    }

    static void howToDo(int param) {
        System.out.println("Hi I am message--- " + param + " running on Thread id " + Thread.currentThread().getName());
    }
}

class PermitController {
    private final int numPermits;
    private final Semaphore permits;

    public PermitController(int numPermits) {
        this.numPermits = numPermits;
        this.permits = new Semaphore(numPermits);
    }

    public void acquire() throws InterruptedException {
        this.permits.acquire();
    }

    public void acquire(int numToAcquire) throws InterruptedException {
        this.permits.acquire(numToAcquire);
    }

    public synchronized void release() {
        if (this.permits.availablePermits() < this.numPermits) {
            this.permits.release();
        }

    }

    public synchronized void release(int numToRelease) {
        if (this.permits.availablePermits() + numToRelease <= this.numPermits) {
            this.permits.release(numToRelease);
        } else {
            this.permits.release(this.numPermits - this.permits.availablePermits());
        }

    }

    public int availablePermits() {
        return this.permits.availablePermits();
    }
}



