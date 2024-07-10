public class threadExample implements Runnable {

    @Override
    public void run() {
        // Mã code sẽ được thực thi trong luồng chạy ngầm
        for (int i = 0; i < 10; i++) {
            System.out.println("Luồng chạy ngầm: " + i);
            String name = Thread.currentThread().getName();
            System.out.println("Hello " + name);

            try {
                Thread.sleep(500); // Ngừng luồng trong 0.5 giây
                System.out.println("Hi " + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        threadExample threadExample = new threadExample();

        // Tạo luồng mới
        Thread thread = new Thread(threadExample);

        // Bắt đầu luồng
        thread.start();

        // In ra thông báo cho biết luồng đã được khởi chạy
        System.out.println("Luồng đã được khởi chạy!");
    }
}
