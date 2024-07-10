import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class threadPoolExample {

    public static void main(String[] args) {
        // Tạo ThreadPool với 4 luồng
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        // Nộp các tác vụ cho ThreadPool
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorService.submit(() -> {
                System.out.println("Tác vụ " + finalI + " đang được thực thi");
                try {
                    Thread.sleep(500); // Ngừng luồng trong 0.5 giây
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // Tắt ThreadPool sau khi tất cả các tác vụ đã hoàn thành
        executorService.shutdown();

        // Chờ cho đến khi tất cả các tác vụ đã hoàn thành
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Tất cả các tác vụ đã hoàn thành!");
    }
}
