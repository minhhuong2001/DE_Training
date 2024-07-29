## OOP
### Tính đóng gói(Encapsulation)
- Đóng gói là đặt tất cả các biến, phương thức trong một Lớp(Class)
Cho phép ẩn các dữ liệu "nhạy cảm" khỏi người dùng. Ta cần khai báo biến, thuộc tính có kiểu là private và cung cấp các methods: get, set để truy cập, cập nhật dữ liệu.
- Các thuộc tính name, age, major, studentCode được khai báo là private Giúp che giấu thông tin đối tượng và chỉ cho phép truy cập qua các phương thức getter, setter.
### Tính kế thừa (Inheritance)
-Tính kế thừa cho phép xây dựng một lớp mới (lớp Con), kế thừa và tái sử dụng các thuộc tính, phương thức dựa trên lớp cũ (lớp Cha) đã có trước đó. 
- Chương trình có lớp Student kế thừa từ lớp Person
###  Tính đa hình (Polymorphism)
-Tính đa hình trong lập trình OOP cho phép các đối tượng khác nhau thực thi chức năng giống nhau theo những cách khác nhau.
-Phương thức getFullname() trong lớp Person dùng để lấy toàn bộ Họ và tên. Phương thức này được ghi đè trong lớp với các thuộc tính khác nhau.
### Tính trừu tượng (Abstraction)
-Person là lớp trừu tượng chứa phương thức trừu tượng getFullname().

## 5 tính chất của solid
### 1. Single Responsibility Principle (SRP) - Nguyên tắc trách nhiệm duy nhất
Nguyên tắc: Một class chỉ nên chịu 1 trách nhiệm duy nhất

Giải thích: Một class không nên thực hiện quá nhiều nhiệm vụ khác nhau. Việc chia nhỏ trách nhiệm sẽ giúp code dễ hiểu, dễ bảo trì hơn và giảm thiểu rủi ro khi thay đổi.
   
Ví dụ: Lớp User chỉ nên quản lý thông tin về người dùng, không nên thực hiện các nhiệm vụ như gửi email hay ghi log.

### 2. Open/Closed Principle (OCP) - Nguyên tắc mở rộng, đóng kín
Nguyên tắc: Các class nên mở để mở rộng nhưng đóng để sửa đổi.

Giải thích: Khi cần thêm tính năng mới, chúng ta nên tạo các lớp con hoặc sử dụng các cơ chế mở rộng khác thay vì sửa đổi trực tiếp code cũ.
   
Ví dụ: Sử dụng interface và kế thừa để tạo ra các lớp con mới, thay vì sửa đổi trực tiếp lớp cha.

### 3. Liskov Substitution Principle (LSP) - Nguyên tắc thay thế Liskov
Nguyên tắc: Các đối tượng của lớp con phải có thể thay thế được các đối tượng của lớp cha mà không làm hỏng tính đúng đắn của chương trình.
   
Giải thích: Lớp con phải tuân thủ hợp đồng (contract) của lớp cha.

Ví dụ: Nếu lớp Square kế thừa từ lớp Rectangle, thì mọi nơi sử dụng Rectangle đều phải hoạt động bình thường khi thay thế bằng Square.

### 4. Interface Segregation Principle (ISP) - Nguyên tắc phân tách giao diện
Nguyên tắc: Nhiều giao diện chuyên biệt tốt hơn một giao diện chung.

Giải thích: Không nên tạo ra các giao diện quá lớn mà hãy chia nhỏ chúng thành các giao diện nhỏ hơn, chuyên biệt hơn.
   
Ví dụ: Thay vì có một giao diện IShape với nhiều phương thức, ta có thể chia thành các giao diện nhỏ hơn như I2DShape và I3DShape.

### 5. Dependency Inversion Principle (DIP) - Nguyên tắc đảo ngược phụ thuộc
Nguyên tắc: Các module cấp cao không nên phụ thuộc vào các module cấp thấp. Cả hai nên phụ thuộc vào các trừu tượng. Các trừu tượng không nên phụ thuộc vào các chi tiết. Chi tiết nên phụ thuộc vào các trừu tượng.
   
Giải thích: Các lớp cấp cao không nên biết chi tiết về cách thức hoạt động của các lớp cấp thấp.
   
Ví dụ: Sử dụng interface để định nghĩa các hợp đồng giữa các lớp, giúp giảm thiểu sự phụ thuộc trực tiếp giữa các lớp.
### UML
![alt text](image-1.png)
### Các khái niệm
-Interface: là một lớp trừu trượng ,tập hợp các phương thức trừu tượng và hằng số được sử dụng để định nghĩa hành vi chung cho một nhóm các lớp. Để truy cập các phương thức trong interface thì Interface cần được implements bởi các lớp khác
- Static
    + Biến tĩnh thuộc về một lớp chứ không thuộc về một đối tượng cụ thể của lớp đó. Biến tĩnh được chia sẻ bởi tất cả các đối tượng của lớp.
    + Phương thức tĩnh thuộc về một lớp chứ không thuộc về một đối tượng cụ thể của lớp đó. Phương thức tĩnh có thể được gọi mà không cần tạo đối tượng của lớp.
    
