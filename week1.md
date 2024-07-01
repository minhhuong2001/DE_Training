## OOP
### Tính đóng gói(Encapsulation)
- Đóng gói là đặt tất cả các biến, phương thức trong một Lớp(Class)
Cho phép ẩn các dữ liệu "nhạy cảm" khỏi người dùng. Ta cần khai báo biến, thuộc tính có kiểu là private và cung cấp các methods: get, set để truy cập, cập nhật dữ liệu.
- Chương trình có các thuộc tính như radius của lớp Circle và length,width của lớp Rectangle được khai báo quyền truy cập là private. Giúp che giấu thông tin đối tượng và chỉ cho phép truy cập qua các phương thức getter, setter.
### Tính kế thừa (Inheritance)
-Tính kế thừa cho phép xây dựng một lớp mới (lớp Con), kế thừa và tái sử dụng các thuộc tính, phương thức dựa trên lớp cũ (lớp Cha) đã có trước đó. 
- Chương trình có lớp Circle, Rectangle là các lớp con kế thừa các thuộc tính và phương thức của lớp cha Shape
###  Tính đa hình (Polymorphism)
-Tính đa hình trong lập trình OOP cho phép các đối tượng khác nhau thực thi chức năng giống nhau theo những cách khác nhau.
-Phương thức area() trong lớp Shape dùng để tính diện tích của hình. Phương thức này được ghi đè trong các lớp con để tính diện tích của các hình khác nhau với các thuộc tính khác nhau.
-Phương thức draw() được triển khai trong các lớp 
### Tính trừu tượng (Abstraction)
-Shape là lớp trừu tượng chứa phương thức trừu tượng draw.
### Class Diagram
![alt text](image.png)
### Các khái niệm
- Interface là một lớp trừu tượng dùng để nhóm các phương thức trừu tượng
-Static
+ Biến tĩnh thuộc về một lớp chứ không thuộc về một đối tượng cụ thể của lớp đó.Biến tĩnh được chia sẻ bởi tất cả các đối tượng của lớp.
Phương thức tĩnh thuộc về một lớp chứ không thuộc về một đối tượng cụ thể của lớp đó. Phương thức tĩnh có thể được gọi mà không cần tạo đối tượng của lớp.