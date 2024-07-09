import java.util.ArrayList;
import java.util.List;

public class ArrayList {
    public static void main(String[] args) {
        // Khởi tạo một ArrayList
        List<String> myList = new ArrayList<>();

        // Thêm các phần tử vào ArrayList
        myList.add("apple");
        myList.add("banana");
        myList.add("cherry");

        // Truy cập phần tử theo chỉ mục
        String secondFruit = myList.get(1);
        System.out.println("Phần tử thứ hai: " + secondFruit);

        // Duyệt qua tất cả các phần tử của ArrayList
        for (String fruit : myList) {
            System.out.println(fruit);
        }

        // Xóa phần tử "banana"
        myList.remove("banana");
        System.out.println("Số lượng phần tử sau khi xóa: " + myList.size());
    }
}
