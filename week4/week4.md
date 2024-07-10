## Mysql
![alt text](img1.png)
### Connection Management
Mỗi kết nối của client (phần mềm truy cập) sẽ có một tiến trình (thread) riêng biệt trên server (máy chủ), và bên trong kết nối đó, truy vấn sẽ được thực thi cho client. Máy chủ cũng quản lý các thread cache (bộ nhớ đệm tiến trình) để giảm thiểu chi phí quản lý kết nối. Máy chủ cho phép truy cập vào mỗi yêu cầu kết nối của client với phương thức xác thực dựa trên tên người dùng, mật khẩu và host (máy chủ của client).

Các chiến lược quản lý kết nối MySQL:
- Sử dụng connection pool: Connection pool là một cách hiệu quả để quản lý kết nối MySQL. MySQL cung cấp một số implementation khác nhau cho connection pool, chẳng hạn như MySQLConnectionPoolDataSource và HikariCP.
- Điều chỉnh kích thước connection pool: Kích thước connection pool nên được điều chỉnh phù hợp với nhu cầu của ứng dụng. Nếu pool quá nhỏ, có thể dẫn đến tình trạng thiếu kết nối và giảm hiệu suất. Nếu pool quá lớn, có thể lãng phí tài nguyên.
- Thiết lập timeout: Timeout nên được thiết lập phù hợp với thời gian sử dụng kết nối trung bình của ứng dụng. Nếu timeout quá ngắn, có thể dẫn đến việc đóng kết nối không cần thiết. Nếu timeout quá dài, có thể dẫn đến việc chiếm dụng kết nối bởi các client không hoạt động.
- Giám sát hiệu suất kết nối: Hiệu suất kết nối nên được giám sát để xác định các vấn đề tiềm ẩn, chẳng hạn như rò rỉ kết nối hoặc pool quá nhỏ.
### Query Cache
Bộ nhớ cache trong MySQL đóng vai trò thiết yếu cho hiệu suất và chủ yếu được sử dụng dưới dạng Query Cache (bộ nhớ cache truy vấn) và Key Cache (bộ nhớ cache key). Khi một client gửi một truy vấn tương tự, máy chủ sẽ không phân tích cú pháp và thực thi lại truy vấn đó mà chỉ cần trích xuất kế hoạch thực thi từ Query Cache. Trong khi đó, Key Cache được dùng để lưu trữ các chỉ mục bảng (table index), sau đó được sử dụng bởi các công cụ lưu trữ (storage engine).

Query Cache được kích hoạt theo mặc định trong MySQL. Để kiểm tra trạng thái của Query Cache, bạn có thể sử dụng lệnh sau:

`SHOW VARIABLES LIKE 'query_cache_type';`

Kết quả sẽ hiển thị giá trị của biến query_cache_type. Nếu giá trị là ON, Query Cache được kích hoạt. Nếu giá trị là OFF, Query Cache bị vô hiệu hóa.
### Parser (bộ phân tích cú pháp)
Là một thành phần quan trọng trong hệ thống quản trị cơ sở dữ liệu MySQL. Nó chịu trách nhiệm phân tích cú pháp của các truy vấn SQL do người dùng gửi đến, đảm bảo rằng truy vấn được viết hợp lệ và có thể được thực thi bởi MySQL.

Quá trình phân tích cú pháp của Parser bao gồm các bước sau:
- Phân chia chuỗi truy vấn thành các token: Mỗi token là một đơn vị cú pháp cơ bản, chẳng hạn như từ khóa, tên bảng, tên cột hoặc toán tử.
- Phân tích cấu trúc ngữ pháp của truy vấn: Parser xác định mối quan hệ giữa các token và đảm bảo rằng truy vấn tuân theo các quy tắc ngữ pháp của SQL.
- Kiểm tra tính hợp lệ của truy vấn: Parser kiểm tra xem các bảng, cột và các đối tượng khác được tham chiếu trong truy vấn có tồn tại hay không và đảm bảo rằng các thao tác được thực hiện hợp lệ.
- Xây dựng cây phân tích cú pháp: Cây phân tích cú pháp là một biểu diễn cấu trúc ngữ pháp của truy vấn. Cây này được sử dụng bởi các thành phần khác của MySQL để xử lý truy vấn.

e.g: SELECT name FROM users WHERE id=1;
![alt text](img2.png)
### Optimizer
Trình tối ưu hóa chịu trách nhiệm tạo ra kế hoạch thực thi hiệu quả nhất cho các truy vấn SQL. Kế hoạch thực thi xác định cách thức truy vấn sẽ được thực thi, bao gồm các bảng nào sẽ được truy cập, các chỉ mục nào sẽ được sử dụng và các thao tác nào sẽ được thực hiện trên dữ liệu.
![alt text](img4.png)

Hoạt động của Optimizer:
- Phân tích cú pháp: Optimizer bắt đầu bằng việc phân tích cú pháp truy vấn SQL để hiểu cấu trúc và ý nghĩa của truy vấn.
- Phân tích ngữ nghĩa: Sau đó, Optimizer tiến hành phân tích ngữ nghĩa để xác định các đối tượng được tham chiếu trong truy vấn, bao gồm bảng, cột, điều kiện lọc và biểu thức.
- Lựa chọn chiến lược truy vấn: Dựa trên thông tin thu thập được, Optimizer sẽ lựa chọn chiến lược truy vấn phù hợp nhất, ví dụ như sử dụng chỉ mục, quét bảng đầy đủ, hoặc kết hợp cả hai.
- Tạo kế hoạch thực thi: Optimizer sẽ tạo ra một kế hoạch thực thi chi tiết, bao gồm các bước cụ thể để thực hiện truy vấn, thứ tự thực hiện các thao tác, và các nguồn lực cần thiết.
- Lựa chọn thuật toán: Optimizer sẽ lựa chọn thuật toán tối ưu cho từng thao tác trong kế hoạch thực thi, ví dụ như thuật toán sắp xếp, thuật toán kết hợp, hoặc thuật toán tham gia.
- Điều chỉnh kế hoạch: Dựa trên thông tin thống kê và các yếu tố khác, Optimizer có thể điều chỉnh kế hoạch thực thi để tối ưu hóa hiệu suất cho từng truy vấn cụ thể.

![alt text](img3.png)

### Storage Engine
#### InnoDB
Là cơ chế lưu dữ liệu mặc định cho MySQL. Có 1 một lời khuyên rằng "You should use InnoDB for your tables unless you have a compelling need to use a different engine" để nói lên sự phổ biến và hữu dụng của cơ chế lưu trữ này. 

InnoDB sử dung cơ chế MVCC để đạt được tính đồng bộ cao, cách đánh index của InnoDB cũng khác với các cơ chế lưu trữ khác của MySQL. 

Đặc điểm chính của InnoDB:
- Hỗ trợ giao dịch ACID: InnoDB đảm bảo tính toàn vẹn dữ liệu bằng cách hỗ trợ các tính năng giao dịch ACID (Nguyên tử, nhất quán, cô lập, bền vững).
- Khóa hàng: InnoDB sử dụng khóa cấp hàng và khóa cấp bản ghi để ngăn chặn tình trạng tranh chấp dữ liệu khi nhiều người dùng truy cập và cập nhật dữ liệu đồng thời.
- Hỗ trợ foreign key: InnoDB hỗ trợ foreign key để đảm bảo tính toàn vẹn tham chiếu dữ liệu giữa các bảng.
- Phục hồi dữ liệu: InnoDB cung cấp cơ chế phục hồi dữ liệu tốt, giúp giảm thiểu nguy cơ mất dữ liệu do lỗi phần cứng hoặc phần mềm.
- Khả năng mở rộng: InnoDB có thể được mở rộng bằng cách thêm dung lượng lưu trữ hoặc máy chủ vào hệ thống.

Ưu điểm của InnoDB:
- Tính toàn vẹn dữ liệu: InnoDB đảm bảo tính toàn vẹn dữ liệu cao nhờ hỗ trợ giao dịch ACID và khóa hàng.
- Khả năng mở rộng: InnoDB có thể được mở rộng dễ dàng để đáp ứng nhu cầu của các ứng dụng lớn.
- Độ tin cậy cao: InnoDB là engine lưu trữ tin cậy với khả năng phục hồi dữ liệu tốt.
- Hỗ trợ nhiều tính năng: InnoDB hỗ trợ nhiều tính năng cao cấp, chẳng hạn như foreign key, triggers và stored procedures.

Nhược điểm của InnoDB:
- Tốc độ truy xuất dữ liệu: InnoDB có thể chậm hơn MyISAM cho các truy vấn chỉ đọc.
- Tiêu hao dung lượng: InnoDB lưu trữ dữ liệu và chỉ mục trong các tập tin riêng biệt, có thể tốn nhiều dung lượng lưu trữ hơn MyISAM.
#### MyISAM
MyISAM là một engine lưu trữ phổ biến trong hệ quản trị cơ sở dữ liệu MySQL. Nó được biết đến với tốc độ truy xuất dữ liệu nhanh và đơn giản, dễ sử dụng. Tuy nhiên, MyISAM có một số hạn chế về tính năng so với các engine khác, chẳng hạn như InnoDB.

Đặc điểm chính của MyISAM:
- Tốc độ truy xuất dữ liệu nhanh: MyISAM sử dụng cơ chế lưu trữ bảng dạng tập tin, giúp truy xuất dữ liệu nhanh chóng, đặc biệt là đối với các truy vấn chỉ đọc.
- Dễ sử dụng: MyISAM là engine lưu trữ mặc định trong MySQL và được cấu hình đơn giản.
- Hỗ trợ tốt cho các ứng dụng chỉ đọc: MyISAM phù hợp cho các ứng dụng chỉ đọc, chẳng hạn như website tĩnh hoặc kho dữ liệu.
- Không hỗ trợ giao dịch ACID: MyISAM không hỗ trợ các tính năng giao dịch ACID (Nguyên tử, nhất quán, cô lập, bền vững), do đó không phù hợp cho các ứng dụng đòi hỏi tính toàn vẹn dữ liệu cao.
- Không hỗ trợ khóa hàng: MyISAM sử dụng khóa cấp bảng, có thể gây ra tình trạng tranh chấp dữ liệu khi nhiều người dùng truy cập và cập nhật dữ liệu đồng thời.

Ưu điểm của MyISAM:
- Tốc độ: MyISAM là engine lưu trữ nhanh nhất trong MySQL cho các truy vấn chỉ đọc.
- Dễ sử dụng: MyISAM là engine lưu trữ dễ sử dụng và cấu hình đơn giản.
- Tiết kiệm dung lượng: MyISAM lưu trữ dữ liệu và chỉ mục trong cùng một tập tin, giúp tiết kiệm dung lượng lưu trữ.

Nhược điểm của MyISAM:
- Không hỗ trợ giao dịch ACID: MyISAM không phù hợp cho các ứng dụng đòi hỏi tính toàn vẹn dữ liệu cao.
- Không hỗ trợ khóa hàng: MyISAM có thể gây ra tình trạng tranh chấp dữ liệu khi nhiều người dùng truy cập và cập nhật dữ liệu đồng thời.
- Hạn chế về tính năng: MyISAM không hỗ trợ một số tính năng cao cấp như replication và foreign key.

### NDB Cluster
NDB Cluster là một công cụ lưu trữ được phân tán, được thiết kế cho các ứng dụng đòi hỏi hiệu suất cao, khả năng mở rộng và tính sẵn sàng cao. Nó được tích hợp vào MySQL Server, cho phép người dùng sử dụng các tính năng của MySQL cùng với khả năng mở rộng và tính sẵn sàng của NDB Cluster.

Đặc điểm chính
- Phân tán: NDB Cluster lưu trữ dữ liệu trên nhiều máy chủ, giúp tăng hiệu suất và khả năng mở rộng.
- Khả năng sẵn sàng cao: NDB Cluster có thể chịu được sự cố phần cứng và phần mềm mà không bị mất dữ liệu.
- Giao dịch ACID: NDB Cluster hỗ trợ các giao dịch ACID (Nguyên tử, nhất quán, cô lập, bền vững), đảm bảo tính toàn vẹn dữ liệu.
- Khả năng mở rộng: NDB Cluster có thể được mở rộng bằng cách thêm máy chủ vào cụm.
- Tích hợp với MySQL Server: NDB Cluster được tích hợp vào MySQL Server, cho phép người dùng sử dụng các tính năng của MySQL cùng với khả năng mở rộng và tính sẵn sàng của NDB Cluster.

|     **Tính năng**     |         **InnoDB**        |                       **MyISAM**                      |                          **NDB Cluster**                         |   |
|:---------------------:|:-------------------------:|:-----------------------------------------------------:|:----------------------------------------------------------------:|---|
| Loại                  | General-purpose           | Non-transactional                                     | Distributed                                                      |   |
| Giao dịch ACID        | Hỗ trợ đầy đủ             | Không hỗ trợ                                          | Hỗ trợ đầy đủ                                                    |   |
| Khóa                  | Khóa hàng và khóa bản ghi | Khóa cấp bảng                                         | Khóa hàng và khóa bản ghi                                        |   |
| Tính toàn vẹn dữ liệu | Cao                       | Thấp                                                  | Cao                                                              |   |
| Khả năng mở rộng      | Tốt                       | Trung bình                                            | Rất tốt                                                          |   |
| Phục hồi dữ liệu      | Tốt                       | Yếu                                                   | Rất tốt                                                          |   |
| Tốc độ đọc            | Trung bình                | Nhanh nhất                                            | Trung bình                                                       |   |
| Tốc độ ghi            | Trung bình                | Nhanh                                                 | Trung bình                                                       |   |
| Phức tạp              | Trung bình                | Đơn giản                                              | Phức tạp                                                         |   |
| Phù hợp cho           | Hầu hết các ứng dụng      | Ứng dụng chỉ đọc, không cần tính toàn vẹn dữ liệu cao | Ứng dụng đòi hỏi hiệu suất cao, khả năng mở rộng và sẵn sàng cao |   |


