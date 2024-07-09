import java.util.HashSet;
import java.util.Set;

public class HashSet{
    public static void main(String[] args) {
        // Khởi tạo một HashSet
        Set<String> myHashSet = new HashSet<>();

        // Thêm các phần tử vào HashSet
        myHashSet.add("apple");
        myHashSet.add("banana");
        myHashSet.add("cherry");

        // Kiểm tra xem phần tử "banana" có tồn tại trong HashSet không
        boolean containsBanana = myHashSet.contains("banana");
        System.out.println("Có chứa phần tử \"banana\": " + containsBanana);

        // Xóa phần tử "cherry" khỏi HashSet
        myHashSet.remove("cherry");
        System.out.println("Số lượng phần tử sau khi xóa: " + myHashSet.size());

        // Duyệt qua tất cả các phần tử của HashSet
        for (String fruit : myHashSet) {
            System.out.println(fruit);
        }
    }
}
