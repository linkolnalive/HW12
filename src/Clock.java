import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Clock {
    private static long start;
    private static final Runnable currentTime = new Runnable() {
        public void run() {
            System.out.println((int)((System.currentTimeMillis() - start) / 1000f));
        }
    };
    private static final Runnable fiveSecondsNotify = new Runnable() {
        public void run() {
            System.out.println("Минуло 5 секунд");
        }
    };
    public static void time() {
        start = System.currentTimeMillis();
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.scheduleAtFixedRate(currentTime, 1, 1, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(fiveSecondsNotify, 5, 5, TimeUnit.SECONDS);
    }
}
