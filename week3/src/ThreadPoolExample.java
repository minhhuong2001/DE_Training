import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
// Tạo một ThreadPool với 4 luồng làm việc
        ExecutorService executorService = Executors.newFixedThreadPool(4);
// Gửi 10 tác vụ đến ThreadPool
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            Runnable task = () -> {
                System.out.println("Task"+ taskId + "is being executed by thread" + Thread.currentThread().getName());
            };
            executorService.submit(task);
        }
// Đóng ThreadPool sau khi hoàn thành tất cả các tác vụ
        executorService.shutdown();
    }
}