(1) Dữ liệu lớn và Hadoop ecosystem, khai niệm cơ bản về hdfs, yarn, spark
(2) Quá trình đọc ghi trong hdfs, khái niệm namenode, datanode, secondary namenode, hdfs block, block
replication, 
(3) Các thành phần của yarn, khái niệm về mapreduce
(4) Các thành phần của spark, spark api(action, tranformation), 

# Hadoop
Apache Hadoop là một framework mã nguồn mở nhằm mục đích giúp tương tác với dữ liệu lớn dễ dàng hơn.

Hadoop Ecosystem là một platform hoặc một bộ cung cấp các dịch vụ khác nhau để giải quyết các vấn đề về dữ liệu lớn. Có bốn thành phần chính của Hadoop là HDFS, MapReduce, YARN và Hadoop Common Utilities .
- HDFS: Hadoop Distributed File System
- YARN: Yet Another Resource Negotiator
- MapReduce: Programming based Data Processing
- Spark: In-Memory data processing

## HDFS
hdfs là thành phần chính, quan trọng của Hadoop ecosystem, chịu trách nhiệm cho việc lưu trữ lượng lớn các data sets có cấu trúc hoặc không có cấu trúc thông qua các nodes, lưu trữ  metadata 

2 thành phần chính:
- namenode: là node chứa các metadata( data about data) , yêu cầu ít tài nguyên lưu trữ hơn data node 
- datanode lưu trữ dữ liệu
hdfs 




