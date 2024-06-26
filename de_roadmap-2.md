## Data Engineer Training

Update 01/12/2023

Tài liệu cho khóa train cơ bản cho thực tập parttime trong vòng 3 tháng   

Thiết kế 3 ngày * 4 tuần * 3 tháng. Review theo tuần tức tương đương 12 đơn vị bài làm

Lộ trình bao gồm:

- 4 Tuần đầu: Java core cơ bản, cơ sở dữ liệu cơ bản, Maven, OOP, Serialize
- 4 Tuần tiếp theo: Cơ sở lí thuyết cho dữ liệu lớn hadoop, hdfs, yarn, mapreduce, spark
- 4 Tuần cuối: Cài cắm cụm hadoop, xây dựng một luồng data cơ bản.

Các yêu cầu chung: 

(1) sinh viên nhận task theo tuần để tự tự tìm hiểu.
(2) thắc mắc liên hệ người hướng dẫn, không quá 30p/ ngày.
(3) thực tập sinh liên hệ người hướng dẫn vào buổi cuối của mỗi tuần để review công việc (không quá 15 phút/ lần).
(4) xong sớm có thể báo review sớm và chuyển sang phần tiếp theo.
(5) trước khi review yêu cầu viết file report(các công việc đã làm, kết quả công việc, code nếu có, các khó khăn cần giải đáp) bằng markdown đẩy lên github cá nhân sau đó gửi trước cho người hướng dẫn, mỗi tuần là một file markdown.


### 1. Tuần 1

#### 1.1. Yêu cầu (1): oop
- Mô tả: xây dựng chương trình java bất kì có sử dụng đầy đủ 4 tính chất của oop, 5 tính chất trong SOLID
- Tham khảo: http://www.w3resource.com/java-tutorial/java-object-oriented-programming.php
- Điều kiên hoàn thành: Từ chương trình đã xây dựng trình bày về đã áp dụng oop như nào, (2) hiểu các khái niệm interface, static, viết các biểu đồ UML liên quan

#### 1.2. Yêu cầu (2) Đọc ghi file
- viết trương trình java đọc ghi file theo 2 dạng binary và text
- viết trương trình java thao tác với file và thư mục: list các file, đọc nội dung file

### 2. Tuần 2

#### 2.1. Collection(s)

- Mô tả: viết trương trình java sử dụng các cấu trúc dữ liệu HashMap, HashSet, ArrayList
- Tham khảo (Overview) http://cs.lmu.edu/~ray/notes/collections/ (compare) http://www.codejava.net/java-core/collections/java-collections-framework-summary-table (performance) http://infotechgems.blogspot.com/2011/11/java-collections-performance-time.html
- Điều kiên hoàn thành: Cần nắm được HashMap,HashSet,ArrayList là gì, cách phương thức sử dụng ra sao, so sánh các đặc điểm. nắm được khái niệm hashcode, equals và lấy ví dụ minh họa sử dụng của hashcode, equal trong Set.

#### 2.2. Design Pattern
- Đọc hiểu các Design Pattern cơ bản, lựa chọn ít nhất 3 Design Pattern (mỗi cái thuộc một trong các nhóm khởi tạo, hành vi và cấu trúc) để implement bằng java và trình bày lại. Cần vẽ các biểu đồ uml liên quan.

#### 2.3. Serialize
- tìm hiểu liên quan serialize trong java. (viết code ví dụ minh họa bằng java và giải thích code) (phần này có chút liên quan tới trên cơ sở kiến thức từ 1.2, thực tập sinh có thể code liên hệ với code cũ)

### 3. Tuần 3

#### 3.1. Exception
- nắm được cách xử lí exception, hệ thống các exception trong java, lấy ví dụ về ít nhất 2 loại exception(Checked Exception và Unchecked Exception)  và cách fix nó.
- tham khảo: http://www.journaldev.com/1696/java-exception-handling-tutorial-with-examples-and-best-practices

#### 3.2 Concurrency:
- Yêu cầu: (1) viết 1 luồng chạy ngầm kế thừa Runnable sử dụng java, (2) viết chương trình sử dụng threadpool bằng ngôn ngữ java
- tham khảo: http://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/
- tìm hiểu lock, atomic integer, concurrent hashmap, race condition, virtual thread(java 21)
- Seminar: thực tập sinh trong phần này cần làm silde thuyết trình về những tìm hiểu của mình và trình bày với team.

#### 3.3. json 
- Yêu cầu: Dựa trên Serialize ở java tại mục 2.2, viết code có sử dụng json (yêu cầu  có sử dụng maven)
- tham khảo: (1)https://www.tutorialspoint.com/json/json_overview.htm, (2) http://www.tutorialspoint.com/json/json_java_example.htm
- nắm được json là gì, sử dụng java parse json, lấy giá trị, chuyển jsonobject thành string
- sử dụng thư viện gson để parse trực tiếp 1 string sang 1 object tương ứng


### 4. tuần 4
- Yêu cầu (1): Tự cài đặt một cơ sở dữ liệu trên máy tính (cụ thể là mysql). trình bày chi tiết về các thành phần liên quan (vật lí - parser, optimizer, các loại storage engine, ...)
- Yêu cầu (2): Tự lấy ví dụ về 10 câu query mySQL không tốt và cách tối ưu nó (minh họa bằng explain).
- Yêu cầu (3): Tìm hiểu về các loại db và trình bày lại (ít nhất 3 db thuộc loại sql, 3 db thuộc loại no sql). các khái niệm CAP, BASE, ACID, 3 dạng chuẩn của csdl.

### 5. Tuần 5-6
- Tìm hiểu về bigdata. tham khảo khóa bigdata trên educative ( link khóa học: https://www.educative.io/courses/introduction-to-big-data-and-hadoop/gkNGDgZPY93) , tài khoản sẽ cấp sau)
- Tham khảo doc: https://docs.google.com/document/d/1DNDmlSyefGOA83d0ugFABpK5BmC_FK9G9pp_SIOWm2s/edit
- Các khái niệm cần nắm vững: 
```
(1) Dữ liệu lớn và Hadoop ecosystem, khai niệm cơ bản về hdfs, yarn, spark
(2) Quá trình đọc ghi trong hdfs, khái niệm namenode, datanode, secondary namenode, hdfs block, block
replication, 
(3) Các thành phần của yarn, khái niệm về mapreduce
(4) Các thành phần của spark, spark api(action, tranformation), 

```
- Các khai niệm nâng cao

```
(1) HA trong hdfs(khái niệm JournalNode, zookeeper)
(2) Khái niệm editlog, stand by namenode, fs image 
```

### 6. Tuần 7
- chủ động liên hệ lịch review với người hướng dẫn trong khoảng 1 tiếng để nhận feedback các phần còn thiếu
- tự tỉm hiểu về các phần còn thiếu trong thời gian còn lại 
- cuối tuần này (thứ 7 - hoặc linh động) sẽ tổ chức buổi seminar. mỗi người phải chuẩn bị một slide nói về hadoop-spark và gửi trước 20h thứ 6 tuần này. để trình bày trước nhóm.

### 7. Tuần 8
- giải đáp các mục còn tồn đọng trong tuần 7.
- Yêu cầu tìm hiểu về Shell linux, các câu lệnh liên quan như:

```
- Các command cơ bản: cd, ls, cp, mv, mkdir,cat,head
- Các command liên quan đến quyền : chmod, chown, ls -l
- Các command thực hiện song song:
cat test.txt | wc -l
cat test.txt | grep "a"
cat test.txt | head
echo "aabb"  > test.txt
echo "cc" >> test.txt
- Sử dụng vim: tạo file mới, sửa file, save,vvv
- Quản lý tiến trình: htop, ps aux, kill -9

```
- Yêu cầu tìm hiểu về docker. Điều kiện hoàn thành: viết một chương trình sử dụng rest api cơ bản(GET /ping và response về "pong") bằng flask python. sau đó triển khai service trên docker sao cho đứng bên ngoài máy tính có thể call được service chạy trong docker.

### 8. Tuần 9,10,11
#### 8.1. Setup môi trường cài đặt cụm HDFS, YARN
- Yêu cầu chạy được chương trình word count với hadoop mapreduce
- Lưu ý về phiên bản hadoop, spark. Thực tập sinh cần tìm hiểu sự khác nhau giữa các phiên bản
- Cài đặt hadoop 2.x theo mô hình sau (chú ý cài cơ bản k cần HA): https://github.com/longpt233/shopee-analysis/blob/main/imgs-md/hadoop-spark.png

- Các bạn thực tập sẽ thực hành trên môi trường máy ảo tự cài đặt trên máy tính cá nhân. với mỗi mục cần phải chụp ảnh minh chứng mình đã làm hoàn thiện
- tham khảo: https://www.linode.com/docs/guides/how-to-install-and-set-up-hadoop-cluster/ 

#### 8.2. Cài đặt Spark standalone, spark trên yarn
- yêu cầu chạy được chương trình word count với spark chạy trên yarn (tham khảo https://github.com/longpt233/shopee-analysis/blob/main/imgs-md/hadoop-spark.png)
- tự sinh dữ liệu người dùng , visualize lên bằng pyspark.
- yêu cầu cụ thể: 
```
(1) sinh file parquet trên hệ thống hdfs đã cài đặt: khoảng 1 triệu bản ghi gồm các cột: tên, ngày sinh, địa chỉ (địa chỉ random từ 1-100), giới tính, số điện thoại. 
(2) chạy jupyter notebook 
(3) sử dụng pyspark để đọc file trên notebook. chạy spark chế độ standalone(nâng cao: *có thể chạy trên yarn*) 
(4) visualize: thống kê lượng user theo tuổi (khoảng độ tuổi ví dụ từ 10-20, 20-30 tuổi, ...), giới tính bằng các biểu đồ hợp lí
(5) chuyển các code pyspark về code java và submit với spark chạy trên yarn. ở bước này không cần visualize mà chỉ cần hiên thị số liệu.
```

### 9. Tuần 12
- Sinh viên thực tập sau khi hoàn thành hết toàn bộ công việc (có thể hoàn thành trước hạn), có thể lựa chọn tìm hiểu thêm công nghệ hoặc đề nghị làm chung một số task thực tế với team.
- Ví dụ về tìm hiểu thêm công nghệ như kafka, zookeeper, hbase, nifi, airflow


### Phụ lục

1. danh sách các port cần cấu hình (chỉ dùng cho khi cài trên server thực tế - sử dụng máy ảo để cài thì bỏ qua phần này)
- nên để tránh cấu hình cài đặt (path, port) trùng nhau dẫn đến lỗi, mỗi bạn sẽ sử dụng user và port riêng. Quy tắc: user + số thứ tự, port + số thứ tự.

Ví dụ bạn có số thứ tự là 1, bạn sẽ sử dụng user hdfs1 và yarn1 để cài.

| file config   | config                                           | port  |
|---------------|--------------------------------------------------|-------|
| core-site.xml | fs.defaultFS                                     | 8020  |
| hdfs-site.xml | dfs.namenode.http-address                        | 50070 |
| hdfs-site.xml | dfs.datanode.address                             | 50010 |
| hdfs-site.xml | dfs.datanode.ipc.address	                        | 50020 |
| hdfs-site.xml | dfs.datanode.http.address                        | 50075 |
| yarn-site.xml | yarn.resourcemanager.webapp.address    	         | 8088  |
| yarn-site.xml | yarn.resourcemanager.address                     | 8032  |
| yarn-site.xml | yarn.resourcemanager.resource-tracker.address  	 | 8031  |
| yarn-site.xml | yarn.resourcemanager.scheduler.address           | 8030  |
| yarn-site.xml | yarn.resourcemanager.admin.address	              | 8033  |
| yarn-site.xml | yarn.nodemanager.webapp.address                  | 8042  |
| yarn-site.xml | yarn.nodemanager.localizer.address               | 8040  |

Phía trên là danh sách port mặc định mà hadoop/yarn sẽ sử dụng. Nếu không chỉ định cụ thể, chương trình sẽ sử dụng config
mặc định. Vì vậy cần set cấu hình cụ thể ở file config tương ứng để ghi đè config mặc định.

Ví dụ: với config `dfs.datanode.address` ở file `hdfs-site.xml` mặc định 50010. Thực tế cần đổi = 50010 + 1 * 301(số thứ tự * 101)
```xml
<property>
  <name>dfs.datanode.address</name>
  <value>0.0.0.0:50011</value>
</property>
```
