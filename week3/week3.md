## 1.Exception
Exception là một sự kiện xảy ra trong quá trình thực thi một chương trình Java, nó làm phá vỡ cái flow (luồng xử lý) bình thường của một chương trình, thậm chí chết chương trình.

Các lý do xảy ra Exception
- Người dùng nhập dữ liệu không hợp lệ
- Truy cập ngoài chỉ số mảng.
- Mất kết nối mạng
- Một file cần được mở nhưng không thể tìm thấy.
- Out-of-disk memory

![alt text](img1.png)

Error(lỗi) thể hiện cho các trường hợp không thể khắc phục như JVM hết bộ nhớ, tràn bộ nhớ, stack over flow, v.v
Có 2 loại exception: checked và unchecked. Tất cả các checked exception được kế thừa từ lớp Exception ngoại trừ lớp RuntimeException. RuntimeException là lớp cơ sở của tất cả các lớp unchecked exception. 

![alt text](img2.png)

### 1.1 Checked exceptions
Là loại exception xảy ra trong lúc compile time, nó cũng có thể được gọi là compile time exceptions. Loại exception này không thể bỏ qua được trong quá trình compile, bắt buộc ta phải handle nó.
Ví dụ:
```
try {
            FileReader file = new FileReader("myfile.txt");
            int data = file.read();
            while (data != -1) {
                System.out.print((char) data);
                data = file.read();
            }
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("File không được tìm thấy!");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file!");
        }
```
phương thức FileReader() có thể ném ra ngoại lệ FileNotFoundException nếu file không được tìm thấy, hoặc IOException nếu có lỗi xảy ra khi đọc file.
### 1.2 UnChecked exceptions

Là loại exception xảy ra tại thời điểm thực thi chương trình, nó cũng có thể gọi là runtime exceptions đó là programming bugs, lỗi logic của chương trình… Loại exception này được bỏ qua trong quá trình compile, không bắt buộc ta phải handle nó
Ví dụ:
```
int[] myNumbers = {1, 2, 3};
    System.out.println(myNumbers[10]);
```
`Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 3 at exceptionExample.main(exceptionExample.java:4)`
Xử lý try catch
```
int[] myNumbers = {1, 2, 3};
try {
      System.out.println(myNumbers[10]);
    } catch (Exception e) {
      System.out.println("Something went wrong.");
    }
  }
```
## 2. Concurrency
### 2.1 Thread
Luồng (thread) trong Java là một đơn vị xử lý độc lập trong chương trình, cho phép thực hiện đa luồng (multithreading) để cải thiện hiệu suất và tận dụng tối đa tài nguyên máy tính. Mỗi luồng là một dòng thực thi độc lập trong chương trình, có thể chạy song song với các luồng khác

![alt text](img3.png)

- New

Khi một Thread mới được khởi tạo nhưng chưa bắt đầu chạy, nó ở trạng thái “New”. Ở trạng thái này, Thread chưa được liên kết với hệ thống phân bổ tài nguyên, và chưa được đưa vào hàng đợi CPU. Để bắt đầu chạy một luồng mới, bạn cần gọi phương thức start() của Thread đó.
```
Thread myThread = new Thread(new Runnable() {

@Override

public void run() {

System.out.println(“Thread đang chạy”);

}

});

```
- Runnable

Khi một Thread đã được khởi động bằng phương thức start(), nó chuyển sang trạng thái “Runnable”. Ở trạng thái này, Thread đang chờ đợi CPU để thực thi mã của nó. Trạng thái Runnable không đảm bảo rằng Thread đang thực sự chạy, mà chỉ đơn giản là nó đã sẵn sàng để thực thi và đang chờ đợi tài nguyên.
`myThread.start();`

-Waiting

Trong quá trình hoạt động, một Thread có thể phải chờ một điều kiện nào đó để tiếp tục. Ví dụ, Thread có thể chờ một Thread khác hoàn thành công việc, hoặc chờ một tài nguyên được giải phóng. Khi một Thread ở trạng thái “Waiting”, nó không thực thi mã của nó và giải phóng tài nguyên CPU để các Thread khác có thể sử dụng.

Bạn có thể sử dụng các phương thức như wait(), join(), hoặc LockSupport.park() để đưa một Thread vào trạng thái Waiting.
```
Thread anotherThread = new Thread(new Runnable() {

@Override

public void run() {

System.out.println(“Thread khác đang chạy”);

}

});

myThread.join(); // Chờ anotherThread hoàn thành
```
- Sleeping

Trạng thái “Sleeping” là khi một Thread đang ngủ trong một khoảng thời gian xác định, sau đó tự động chuyển sang trạng thái Runnable. Khi một Thread ở trạng thái Sleeping, nó không thực thi mã của nó và giải phóng tài nguyên CPU.

Để đưa một luồng vào trạng thái Sleeping, bạn có thể sử dụng phương thức sleep().
```
try {

Thread.sleep(1000); // Ngủ trong 1 giây

} catch (InterruptedException e) {

e.printStackTrace();

}

```
- Terminated

Khi một luồng hoàn thành công việc của nó hoặc bị dừng bởi một lý do nào đó, nó chuyển sang trạng thái “Terminated”. Khi một Thread ở trạng thái này, nó không thể tái sử dụng, và bạn cần tạo một Thread mới nếu muốn thực hiện lại công việc đó.

Một số lý do dẫn đến trạng thái Terminated:
- Mã trong phương thức run() của Thread đã hoàn thành.
- Thread gặp phải một ngoại lệ không được xử lý trong phương thức run().
- Phương thức stop() được gọi để dừng Thread (lưu ý: phương thức này đã bị loại bỏ và không nên sử dụng).

```
@Override

public void run() {

System.out.println(“Thread đang chạy”);

// Mã ở đây đã hoàn thành, Thread sẽ chuyển sang trạng thái Terminated

}

```
####  Critical section (đoạn găng)
Đoạn găng (critical section) là một đoạn mã truy cập vào các tài nguyên chia sẻ. Để đảm bảo tính nhất quán của dữ liệu và tránh các tình huống đua (race condition), chỉ có một luồng duy nhất được phép thực thi đoạn mã này tại một thời điểm.

Ví dụ:
Giả sử chúng ta có một biến đếm chung được chia sẻ giữa nhiều luồng. Nếu nhiều luồng cùng lúc tăng giá trị của biến này lên 1, kết quả cuối cùng có thể không chính xác do các luồng "chen ngang" nhau. Để tránh tình trạng này, chúng ta cần bảo vệ đoạn mã tăng giá trị biến đếm bằng một đoạn găng.

Tác dụng:
- Tránh Race Condition: Khi nhiều luồng cùng truy cập và sửa đổi một tài nguyên chia sẻ, thứ tự thực thi của các lệnh có thể không xác định, dẫn đến kết quả không mong muốn.
- Bảo vệ tính toàn vẹn của dữ liệu: Đoạn găng đảm bảo rằng các thao tác trên tài nguyên chia sẻ được thực hiện một cách nguyên tử (atomic), không bị ngắt quãng bởi các luồng khác.

Để thực hiện đoạn găng, các ngôn ngữ lập trình cung cấp các cơ chế đồng bộ hóa như:
- Mutex (Mutual Exclusion): Một đối tượng khóa chỉ cho phép một luồng giữ tại một thời điểm. Luồng muốn vào đoạn găng phải lấy khóa, và khi xong việc phải trả lại khóa.
- Semaphore: Một đối tượng đếm cho phép một số lượng luồng nhất định truy cập vào một tài nguyên.
- Monitor: Một cấu trúc dữ liệu cung cấp các cơ chế đồng bộ hóa như điều kiện, biến khóa, và các phương thức để truy cập vào tài nguyên chia sẻ.
#### Synchonized

Trong lập trình đa luồng, đồng bộ hóa (synchronization) là một cơ chế đảm bảo rằng chỉ có một luồng duy nhất được phép truy cập vào một tài nguyên chia sẻ tại một thời điểm. Điều này đặc biệt quan trọng khi nhiều luồng cùng truy cập vào cùng một dữ liệu, giúp tránh các tình huống đua (race condition) và đảm bảo tính toàn vẹn của dữ liệu.


Java cung cấp từ khóa synchronized để thực hiện đồng bộ hóa. Khi một khối mã được đánh dấu là synchronized, chỉ có một luồng duy nhất có thể thực thi khối mã đó tại một thời điểm.


Synchronized method:
```Java

    public synchronized void method() {
        // Mã cần đồng bộ hóa
    }
    
```
Khi một phương thức được đánh dấu là synchronized, toàn bộ phương thức sẽ trở thành một đoạn găng.

Synchronized block:
```Java

public void method() {
synchronized(this) {
// Mã cần đồng bộ hóa
}
}
```

Với synchronized block, bạn có thể chỉ đồng bộ hóa một phần của phương thức, giúp tăng hiệu suất. Đối tượng được truyền vào synchronized sẽ đóng vai trò là khóa (lock) để bảo vệ đoạn mã.

Cơ chế hoạt động
- Khóa (lock): Khi một luồng thực thi vào một khối mã synchronized, nó sẽ cố gắng lấy khóa tương ứng.
- Nếu khóa đang rảnh: Luồng sẽ lấy được khóa và thực thi khối mã.
- Nếu khóa đang bị luồng khác giữ: Luồng hiện tại sẽ bị chặn cho đến khi khóa được trả lại.
- Khi luồng hoàn thành: Nó sẽ trả lại khóa, cho phép các luồng khác lấy khóa và thực thi.

Ví dụ
```Java

public class Counter {
private int count = 0;

    public synchronized void increment() {
        count++;
    }
}
```
Trong ví dụ trên, phương thức increment() được đồng bộ hóa, đảm bảo rằng chỉ có một luồng có thể tăng giá trị của biến count tại một thời điểm, tránh tình trạng nhiều luồng cùng tăng và dẫn đến kết quả sai.

Ưu điểm và nhược điểm

    Ưu điểm:
        Đảm bảo tính toàn vẹn của dữ liệu.
        Dễ sử dụng và hiểu.
    Nhược điểm:
        Hiệu suất: Đồng bộ hóa có thể làm giảm hiệu suất của chương trình, đặc biệt khi có nhiều luồng tranh giành tài nguyên.
        Deadlock: Nếu các luồng lấy khóa theo thứ tự khác nhau, có thể dẫn đến deadlock.
        Livelock: Các luồng liên tục thay đổi trạng thái nhưng không tiến gần hơn đến trạng thái hoàn thành.

Lưu ý:
- Chọn đối tượng khóa: Đối tượng được truyền vào synchronized đóng vai trò quan trọng. Nên chọn đối tượng sao cho các luồng muốn đồng bộ hóa cùng truy cập đến đối tượng đó.
- Tránh khóa lồng nhau: Việc lồng quá nhiều khối synchronized có thể dẫn đến deadlock.
- Thời gian giữ khóa ngắn: Nên giữ khóa trong thời gian ngắn nhất có thể để tăng khả năng sử dụng đồng thời.




## 3. Các khái niệm
#### 1.Đa nhiệm ưu tiên(preempetive multitasking)

Hệ điều hành có thể bắt đầu chuyển ngữ cảnh từ tiến trình đang chạy sang tiến trình khác. Nói cách khác, hệ điều hành cho phép dừng việc thực thi tiến trình hiện đang chạy và phân bổ CPU cho một số tiến trình khác. HĐH sử dụng một số tiêu chí để quyết định thời gian một tiến trình sẽ thực thi trước khi cho phép một tiến trình khác sử dụng hệ điều hành. Cơ chế lấy quyền kiểm soát hệ điều hành từ một tiến trình và trao nó cho một tiến trình khác được gọi là quyền ưu tiên

#### 2. Đa nhiệm hợp tác(cooperative multitasking)

Hệ điều hành không bao giờ bắt đầu chuyển ngữ cảnh từ tiến trình đang chạy sang tiến trình khác. Chuyển đổi ngữ cảnh chỉ xảy ra khi các tiến trình tự nguyện nhường quyền kiểm soát theo định kỳ hoặc khi không hoạt động hoặc bị chặn theo logic để cho phép nhiều ứng dụng thực thi đồng thời. Ngoài ra, trong đa nhiệm này, tất cả các quy trình đều hợp tác để sơ đồ lập lịch hoạt động.


- tiến trình: một chương trình đang được thực thi.
- ngữ cảnh: trạng thái của một tiến trình tại một thời điểm nhất định.
- chuyển đổi ngữ cảnh: quá trình lưu trữ trạng thái của tiến trình hiện tại và khôi phục trạng thái của tiến trình khác để cho phép tiến trình khác thực thi.
- lập lịch: quá trình quyết định tiến trình nào sẽ được thực thi tiếp theo và trong bao lâu.

|   |                                                                 Đa nhiệm ưu tiên                                                                 |                                                                             Đa nhiệm hợp tác                                                                            |
|:-:|:------------------------------------------------------------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
| 1 | Đa  nhiệm ưu tiên là một tác vụ được HĐH sử dụng để quyết định thời gian  thực hiện một tác vụ trước khi cho phép một tác vụ khác sử dụng HĐH.   | Đa  nhiệm hợp tác là một loại đa nhiệm máy tính trong đó hệ điều hành không  bao giờ bắt đầu chuyển đổi ngữ cảnh từ một tiến trình đang chạy sang  một tiến trình khác. |
| 2 | Nó làm gián đoạn các ứng dụng và trao quyền kiểm soát cho các quy trình khác ngoài tầm kiểm soát của ứng dụng.                                   | Trong đa nhiệm hợp tác, bộ lập lịch quy trình không bao giờ làm gián đoạn một quy trình một cách bất ngờ.                                                               |
| 3 | Hệ điều hành có thể bắt đầu chuyển đổi ngữ cảnh từ một tiến trình đang chạy sang một tiến trình khác.                                            | Hệ điều hành không bắt đầu chuyển đổi ngữ cảnh từ một tiến trình đang chạy sang một tiến trình khác.                                                                    |
| 4 | Một  chương trình độc hại bắt đầu một vòng lặp vô hạn, nó chỉ gây tổn hại  cho chính nó mà không ảnh hưởng đến các chương trình hoặc luồng khác. | Một  chương trình độc hại có thể khiến toàn bộ hệ thống ngừng hoạt động do  bận chờ đợi hoặc chạy một vòng lặp vô hạn và không từ bỏ quyền kiểm  soát.                  |
| 5 | Đa nhiệm ưu tiên buộc các ứng dụng phải chia sẻ CPU dù muốn hay không.                                                                           | Trong  đa nhiệm hợp tác, tất cả các chương trình phải hợp tác để nó hoạt động.  Nếu một chương trình không hợp tác, nó có thể chiếm CPU.                                |

#### 3. Deadlock
Tình trạng khi hai hoặc nhiều luồng (thread) đang chờ đợi lẫn nhau để giải phóng tài nguyên, dẫn đến việc không luồng nào có thể tiếp tục thực thi. Tình trạng này thường xảy ra trong các ứng dụng đa luồng, đặc biệt khi sử dụng các cơ chế đồng bộ hóa như synchronized hoặc các lớp Lock
- Mutual exclusion (Loại trừ tương hỗ): Một tài nguyên chỉ có thể được sử dụng bởi một luồng tại một thời điểm.
- Hold and wait (Giữ và chờ): Một luồng đang giữ tài nguyên và đang chờ đợi để nhận thêm tài nguyên khác.
- No preemption (Không chiếm đoạt): Một luồng không thể bị lấy đi tài nguyên mà nó đang giữ cho đến khi nó tự nguyện trả lại.
- Circular wait (Chờ tuần hoàn): Có một chuỗi các luồng, trong đó mỗi luồng đang chờ đợi một tài nguyên được giữ bởi luồng tiếp theo trong chuỗi.
#### 4. Liveness
Liveness mô tả khả năng của một hệ thống đảm bảo rằng một tiến trình sẽ tiến hành đến một trạng thái mong muốn trong một khoảng thời gian hữu hạn.
#### 5. livelock
   Livelock là một tình huống mà các tiến trình liên tục thay đổi trạng thái nhưng không tiến gần hơn đến trạng thái hoàn thành.

Sự khác biệt giữa Livelock và Deadlock:
- Deadlock: Các tiến trình bị "mắc kẹt" hoàn toàn, không có tiến trình nào có thể tiến hành.
- Livelock: Các tiến trình vẫn đang hoạt động nhưng không tiến tới giải quyết vấn đề.
#### 6. Starvation
Một tiến trình không bao giờ được cấp tài nguyên cần thiết để tiến hành.

một vài policy cần thiết để quyết định xem có nhận được tài nguyên khi xay ra tiến trình, vì lí do đó dẫn đến một vài tiến trình không nhận được tài nguyên mặc dù không xảy ra deadlock
#### 7. Synchorous
Định nghĩa: Trong lập trình đồng bộ, một tác vụ phải hoàn thành trước khi tác vụ tiếp theo có thể bắt đầu. Tức là, các tác vụ thực hiện tuần tự, chờ đợi kết quả của tác vụ trước đó.

Ưu điểm:
- Dễ hiểu và dễ quản lý: Luồng thực thi rõ ràng, dễ theo dõi.
- Thích hợp cho các tác vụ đơn giản, không yêu cầu hiệu suất cao.

Nhược điểm:
- Hiệu suất thấp: Nếu một tác vụ bị chặn, toàn bộ chương trình có thể bị đình trệ.
- Khó tận dụng tối đa tài nguyên hệ thống: Trong khi một tác vụ đang chờ, các tài nguyên khác như CPU có thể bị lãng phí.

#### 8. Asynchronous 
Định nghĩa: Trong lập trình bất đồng bộ, các tác vụ có thể chạy song song, không cần chờ đợi kết quả của tác vụ khác. Khi một tác vụ được khởi động, nó sẽ tiếp tục thực thi trong nền, và chương trình chính có thể tiếp tục làm việc khác.

Ưu điểm:
- Hiệu suất cao: Tận dụng tối đa tài nguyên hệ thống, đặc biệt khi thực hiện nhiều tác vụ I/O.
- Trải nghiệm người dùng tốt hơn: Ứng dụng vẫn phản hồi được trong khi các tác vụ nền đang chạy.

Nhược điểm:
- Phức tạp hơn: Quản lý các tác vụ bất đồng bộ đòi hỏi kỹ thuật lập trình phức tạp hơn.
- Khó gỡ lỗi: Việc theo dõi và gỡ lỗi các lỗi trong các hệ thống bất đồng bộ có thể khó khăn hơn.


***Khi nào nên sử dụng đồng bộ và bất đồng bộ?***

Sử dụng đồng bộ:
- Các tác vụ đơn giản, không yêu cầu hiệu suất cao.
- Các trường hợp cần đảm bảo thứ tự thực hiện của các tác vụ.

Sử dụng bất đồng bộ:
- Các tác vụ I/O nặng (đọc/ghi file, truy cập mạng).
- Các ứng dụng yêu cầu giao diện người dùng phản hồi nhanh.
- Các hệ thống phân tán.


### ThreadPool
ThreadPool là một tập hợp các luồng làm việc (worker threads) được tạo ra trước và sẵn sàng xử lý các tác vụ. Điều này giúp giảm thiểu chi phí liên quan đến việc tạo và hủy luồng. ThreadPool cho phép  quản lý hiệu quả số lượng luồng đang hoạt động trong ứng dụng và tự động điều chỉnh chúng để đáp ứng nhu cầu.
Ví dụ: 
```
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
```


Một ThreadPool với 4 luồng làm việc và gửi 10 tác vụ đến ThreadPool. ThreadPool sẽ tự động phân công các tác vụ cho các luồng làm việc và thực hiện chúng. Sau khi tất cả các tác vụ hoàn thành, chúng ta đóng ThreadPool.
### lock, atomic integer, concurrent hashmap, race condition, virtual thread
+ Lock :
  - Lock là một cơ chế để đồng bộ hóa truy cập vào tài nguyên chia sẻ giữa các luồng (threads) trong môi trường đa luồng.
  - Locks được sử dụng để đảm bảo rằng chỉ có một luồng có thể thực hiện một hoạt động cụ thể tại một thời điểm.
  - Tuy nhiên, việc sử dụng lock có thể dẫn đến hiện tượng “deadlock” nếu không được quản lý cẩn thận.

+ AtomicInteger :
  - AtomicInteger là một lớp trong Java cho phép thực hiện các phép toán nguyên tử (atomic operations) trên một số nguyên.
  - Nó hỗ trợ các phép toán như tăng (increment), giảm (decrement), và so sánh và đổi (compare-and-swap) mà không cần sử dụng lock.
  - AtomicInteger thường được sử dụng để đếm hoặc theo dõi các giá trị được chia sẻ giữa các luồng.

+ ConcurrentHashMap:
  - ConcurrentHashMap là một cấu trúc dữ liệu trong Java, giống như HashMap, nhưng được thiết kế để hỗ trợ đồng thời (concurrent) truy cập từ nhiều luồng.
  - Nó chia dữ liệu thành các phân đoạn (segments) và sử dụng khóa riêng biệt cho từng phân đoạn, giúp tránh hiện tượng đồng thời (race condition).
  - Trong ConcurrentHashMap, việc đọc không yêu cầu khóa, giúp tối ưu hiệu suất.

+ Race Condition :
  - Race condition xảy ra khi nhiều luồng cùng truy cập và thay đổi dữ liệu chia sẻ mà không được đồng bộ hóa đúng cách.
  - Điều này có thể dẫn đến kết quả không chính xác hoặc không mong muốn.
  - Sử dụng cơ chế đồng bộ hóa như locks hoặc atomic operations để tránh race condition.

+ Virtual Thread :
  - Virtual thread là một khái niệm trong Java ở phiên bản 17 trở lên.
  - Nó cho phép tạo ra các luồng nhẹ (lightweight threads) mà không cần tạo ra các luồng thực sự trên hệ thống.
  - Virtual thread giúp tối ưu việc quản lý luồng và tăng hiệu suất ứng dụng đa luồng.

## 3. Json
JSON (JavaScript Object Notation) là một định dạng dữ liệu nhẹ được sử dụng rộng rãi để trao đổi dữ liệu giữa các ứng dụng. Nó dễ đọc, dễ viết và được hỗ trợ bởi hầu hết các ngôn ngữ lập trình, bao gồm cả Java.

Parse String sang Object 
```
String jsonString =JSON "{\"name\": \"Han\", \"age\": 24, \"address\": \"Hanoi, Vietnam\"}";

        // Parse JSON sang object Person
        Gson gson = new Gson();
        Person person = gson.fromJson(jsonString, Person.class);

        // In thông tin của person
        System.out.println("Tên: " + person.getName());
        System.out.println("Tuổi: " + person.getAge());
        System.out.println("Địa chỉ: " + person.getAddress());
```

