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

## Command
1.  cat: 
Cấu trúc cat command: `cat [OPTION] [FILE]`
- Xem nội dung file: `cat filename.txt`
hạn chế file quá lớn, `cat filename.txt|more`
- Tạo file và ghi nội dung vào đó: `cat > filename.txt`. File được tạo, nhập nội dung, sau khi nhập xong nhấn Ctrl + D để thoát file.
- Ghi nội dung: `cat source.txt > destination.txt`. Ghi nội dung vào cuối file `cat source.txt >> destination.txt`
- Tổng hợp nhiều file thành một: `cat source1.txt source2.txt > destination.txt`
- Hiển thị số dòng: option -n
- Đánh số những dòng không trống: option -b
2. head: in ra N dòng đầu tiên của tệp, giá trị mặc định của N là 10
3. tail: in ra N-1 dòng cuối cùng của tệp, giá trị mặc định của N là 10
4. mkdir:  chưa tồn tại
- tạo thư mục: `mkdir <path_name>`
- tạo nhiều thư mục: `mkdir <path_name_1> <path_name_2> <path_name_3>`
- tạo thư mục kèm thư mục cấp cha: `mkdir -p <path_name>`
    eg: `mkdir -p  /root/blogkdata_parent/blogkdata_dir`
- hiển thị quá trình tạo thư mục: option "-v"

5. cp: và thư mục từ đường dẫn nguồn sang đường dẫn đích
- sao chép tập tin: `cp source.txt  destination.txt`
- sao chép tập tin vào thư mục : `cp source1.txt source2.txt source3.txt dest_directory/`
- sao chép thư mục:` cp -R src_directory dest_directory`
6. mv: di chuyển file hoặc thư mục
7. rm: xóa file hoặc thư mục
8. ls: lấy danh sách tất cả tập tin hoặc thư mục
	ls-l: hiển thị tệp hoặc thư mục, kích thước, ngày, thời gian đã sửa đổi, tên tệp hoặc tên thư mục và chủ sở hữu (owner) tệp và các quyền (permission).
	ls-a: lấy danh sách các file kể cả file ẩn, tệp ẩn bắt đầu bằng ‘.’
9. cd: thay đổi thư mục
## Command liên quan đến quyền


-chmod : sửa đổi quyền truy cập của người dùng
    chmod +rwx filename để thêm quyền
    chmod -rwx directoryname để xóa bỏ quyền. 
    chmod +x filename cho phép quyền thực thi.
    chmod -wx filename xóa quyền ghi, thực thi.

Có 3 nhóm cho sự phân quyền
    owners: these permissions will only apply to owners and will not affect other groups.
    groups: you can assign a group of users specific permissions, which will only impact users within the group.
    all users: these permissions will apply to all users, and as a result, they present the greatest security risk and should be assigned with caution.
    
    
    Read (r): xem file.
    Write (w): ghi, chỉnh sửa file hoặc đường dẫn.
    Execute (x): thực thi file, xem đường dẫn.
    
  hanging directory perm for group owners is similar, but add a “g” for group or “o” for users:

    chmod g+w filename

    chmod g-wx filename

    chmod o+w filename

    chmod o-rwx foldername



To change directory permissions for everyone, use “u” for users, “g” for group, “o” for others, and “ugo” or “a” (for all).

    chmod ugo+rwx foldername to give read, write, and execute to everyone.

    chmod a=r foldername to give only read permission for everyone.


- chown: thay đổi chủ sở hữu của file 

    chown name filename
    chown name foldername
    

These commands will give ownership to someone, but all sub files and directories still belong to the original owner.

You can also combine the group and ownership command by using:

    chown -R name:filename /home/name/directoryname
## Operator
- & 
chạy các command song song, gần như là đồng thời
- wait with &
- ;
- |


## Quản lý tiến trình: 
- top: tìm hiểu những quy trình nào đang chạy trên server 
- htop: cải tiến của top, có sẵn trong repository t
- ps: hiển thị thông tin về tất cả các tiến trình đang chạy trên hệ thống với PID (Process ID) và thông tin khác
`ps -ef`

Nếu bạn muốn tìm một PID cụ thể theo tên tiến trình, bạn có thể sử dụng lệnh grep sẽ liệt kê tất cả các tiến trình đang chạy trên hệ thống và lọc kết quả để chỉ hiển thị những cái chứa thuật ngữ “httpd”.

`ps -ef | grep httpd`

- kill

Lệnh “kill” là một tiện ích quan trọng cho phép người dùng gửi các tín hiệu (dừng hoặc chấm dứt) đến các tiến trình đang chạy, yêu cầu chúng thoát ra lịch sự hoặc bị chấm dứt một cách mạnh mẽ.

Lệnh kill hữu ích khi bạn cần quản lý và kiểm soát các hoạt động của các chương trình khác nhau trên hệ thống Linux của bạn, như:
- Dừng bất kỳ tiến trình tự động nào.
- Dừng một tiến trình đã bắt đầu một cách tình cờ.
- Dừng một tiến trình sử dụng quá nhiều bộ nhớ.
- Chấm dứt một cách mạnh mẽ bất kỳ tiến trình đang chạy nào trong Linux.
- Dừng một tiến trình đang chạy ẩn sau nền.

Lệnh “kill” là một tiện ích quan trọng cho phép người dùng gửi các tín hiệu (dừng hoặc chấm dứt) đến các tiến trình đang chạy, yêu cầu chúng thoát ra lịch sự hoặc bị chấm dứt một cách mạnh mẽ.

Sử dụng lệnh kill từ /usr/bin mang lại cho bạn một số tính năng bổ sung để tiêu diệt một tiến trình theo tên tiến trình bằng cách sử dụng pkill, nhận dạng tiến trình bằng tên của chúng.

Cách tìm PID hoặc tên Process

Trước khi chấm dứt một tiến trình đang chạy, việc xác định Process ID (PID) hoặc tên của nó bằng cách sử dụng lệnh ps sau đây để hiển thị thông tin về tất cả các tiến trình đang chạy trên hệ thống với PID (Process ID) và thông tin khác.

`ps -ef`

Nếu bạn muốn tìm một PID cụ thể theo tên tiến trình, bạn có thể sử dụng lệnh grep sẽ liệt kê tất cả các tiến trình đang chạy trên hệ thống và lọc kết quả để chỉ hiển thị những cái chứa thuật ngữ “httpd”.

`ps -ef | grep httpd`



Cách KILL một Process trong Linux

Trước khi bạn chấm dứt, dừng hoặc kết thúc một tiến trình, hãy nghĩ đến quyền hạn. Nếu bạn là người dùng root, bạn có thể dừng bất kỳ tiến trình nào, nhưng nếu bạn là người dùng thông thường, bạn cần thêm “sudo” trước lệnh hoặc chuyển sang quyền root với “su`” để sử dụng lệnh chấm dứt.

Cú pháp chung cho lệnh kill là:

`kill [signal hoặc option] PID(s)`

Đối với lệnh kill, một signal có thể là:

| Signal Name | Signal Value |  Behaviour  |
|:-----------:|:------------:|:-----------:|
| SIGHUP      | 1            | Hangup      |
| SIGKILL     | 9            | Kill Signal |
| SIGTERM     | 15           | Terminate   |

- SIGTERM là cách mặc định và an toàn nhất để chấm dứt một tiến trình.
- SIGHUP là cách ít an toàn hơn để chấm dứt một tiến trình so với SIGTERM.
- SIGKILL là cách không an toàn nhất trong số ba cách trên, để chấm dứt một tiến trình mà không lưu lại dữ liệu.

Trong Linux, có nhiều signal khác nhau bạn có thể sử dụng để dừng, kết thúc hoặc tạm dừng các tiến trình. Bạn có thể liệt kê tất cả các tín hiệu kill có sẵn với tên và số tương ứng của chúng bằng lệnh sau, sẽ liệt kê:

`kill -l`

Mặc dù có nhiều signal khả dụng, nhưng trong hầu hết các trường hợp, chúng ta chỉ sử dụng SIGKILL (9) và SIGTERM (15).

Để chấm dứt một tiến trình, chúng ta cần biết Process ID của một tiến trình. Mỗi tiến trình trong Linux đều có một pid. Tiến trình đầu tiên bắt đầu khi Hệ thống Linux được khởi động là quá trình init, do đó nó được gán một giá trị ‘1’ trong hầu hết các trường hợp.

Init là quá trình chính và không thể bị chấm dứt theo cách này, điều này đảm bảo rằng quá trình chính không bị chấm dứt một cách tình cờ. Init quyết định và cho phép chính nó bị chấm dứt, nơi lệnh kill chỉ là một yêu cầu tắt máy.

Trước khi chúng ta tiến lên và thực hiện một lệnh kill, có một số điểm quan trọng cần lưu ý:
- 1 User có thể chấm dứt tất cả các tiến trình của mình.
- 1 User dùng không thể chấm dứt tiến trình của người dùng khác.
- 1 User dùng không thể chấm dứt các tiến trình mà Hệ thống đang sử dụng.
- 1 User Root có thể chấm dứt quá trình ở cấp độ hệ thống và quá trình của bất kỳ người dùng nào.

Để chấm dứt quá trình httpd với PID, sử dụng lệnh kill như sau.

`kill -9 1931098`

Lệnh trên sẽ chấm dứt tiến trình có pid=1931098, trong đó PID là Giá trị Số của tiến trình.

Một cách khác để thực hiện chức năng tương tự có thể được viết lại như sau.

`kill -SIGTERM 1931098`

Tương tự, `kill -9 PID` tương đương với `kill -SIGKILL PID` và ngược lại.

Để xác nhận rằng quá trình đã kết thúc, bạn có thể sử dụng lại lệnh ps.

`ps -ef | grep httpd`

Cách KILL nhiều Process trong Linux

Để chấm dứt nhiều tiến trình trong Linux bằng các Process IDs (PIDs) của chúng, bạn có thể sử dụng lệnh kill kết hợp với các số PID tương ứng.

Đầu tiên, xác định các PID của các tiến trình bạn muốn chấm dứt bằng lệnh ps hoặc pgrep.



`ps aux | grep httpd`

hoặc

`pgrep httpd`



Khi bạn có các PID, sử dụng lệnh kill để chấm dứt chúng.

`kill -9 PID1 PID2 PID3`

Cách KILL Process trong Linux bằng tên Process

Để chấm dứt một tiến trình bằng cách sử dụng tên tiến trình, chúng ta sẽ sử dụng lệnh pkill, một phiên bản của lệnh kill cho phép bạn đề cập đến tên tiến trình hoặc một mẫu để định vị một tiến trình.

Bạn phải biết tên tiến trình trước khi chấm dứt, và nhập sai tên tiến trình có thể gây lỗi.

`pkill mysqld`

Nếu một tiến trình có quá nhiều phiên bản và nhiều tiến trình con, chúng ta có lệnh ‘killall‘ nhận tên tiến trình làm đối số thay vì số tiến trình.

Cách KILL một Process trong Linux bằng lệnh Killall

Sự phân biệt chính giữa killall và kill là Killall có thể chấm dứt một tiến trình theo tên của nó, trong khi lệnh kill phụ thuộc vào Process ID (pid).

Để chấm dứt tất cả các phiên bản mysql cùng với các tiến trình con, sử dụng lệnh như sau.

`killall mysqld`
hoặc
`pkill mysqld`

Bạn luôn có thể xác minh trạng thái của tiến trình xem nó đang chạy hay không, bằng cách sử dụng một trong những lệnh dưới đây.

```
systemctl status mysql
pgrep mysql
ps -aux | grep mysql 
```

Các công cụ giám sát hệ thống đồ họa trên Linux như htop hoặc gnome-system-monitor cung cấp giao diện thân thiện với người dùng để tìm và chấm dứt các tiến trình.

## Vim
### Mở file với VIM

Cú pháp

vi [tùy_chọn] [filename]

Khi mở file không có tham số tùy_chọn, nếu file tồn tại, thì trang đầu tiên (hoặc màn hình) của tệp sẽ được hiển thị; nếu tệp không tồn tại, thì tệp và màn hình trống sẽ được tạo để bạn nhập văn bản.
Thêm, thay đổi và xóa văn bản


Các lệnh sau cho phép bạn chèn và thêm văn bản. Mỗi lệnh này đều chuyển trình soạn thảo VIM từ chế độ xem thành chế độ sửa văn bản ở dạng chèn (insert):

| * | i | Chèn văn bản trước con trỏ, thoát ra bằng cách nhấn <Esc>                                  |
|:-:|:-:|--------------------------------------------------------------------------------------------|
|   | I | Chèn văn bản ở đầu dòng hiện tại, thoát ra bằng cách nhấn <Esc>                            |
| * | a | Gắn (append) văn bản sau con trỏ, thoát ra bằng cách nhấn <Esc>                            |
|   | A | Gắn văn bản vào cuối dòng hiện tại, thoát ra bằng cách nhấn <Esc>                          |
| * | o | Mở và đặt văn bản trong một dòng mới bên dưới dòng hiện tại, thoát ra bằng cách nhấn <Esc> |
| * | O | Mở và đặt văn bản trong một dòng mới bên trên dòng hiện tại, thoát ra bằng cách nhấn <Esc> |

### Lưu tệp


| * |  :x | Thoát VIM và lưu tập tin lại |
|:-:|:---:|------------------------------|
|   | :wq | Thoát VIM và lưu tập tin lại |
|   |  :q | Thoát VIM                    |
| * | :q! | Thoát VIM và không lưu.      |
