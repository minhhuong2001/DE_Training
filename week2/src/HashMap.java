import java.util.HashMap;
import java.util.Map;

public class HashMap {
    public static void main(String[] args) {
        // Khởi tạo một HashMap
        Map<String, Integer> myHashMap = new HashMap<>();

        // Thêm các phần tử vào HashMap
        myHashMap.put("apple", 10);
        myHashMap.put("banana", 5);
        myHashMap.put("cherry", 8);

        // Truy cập giá trị bằng key
        int appleCount = myHashMap.get("apple");
        System.out.println("Số lượng quả táo: " + appleCount);

        // Duyệt qua tất cả các phần tử của HashMap
        for (Map.Entry<String, Integer> entry : myHashMap.entrySet()) {
            String fruit = entry.getKey();
            int count = entry.getValue();
            System.out.println(fruit + ": " + count);
        }

        // Kiểm tra xem HashMap có chứa key "banana" không
        boolean containsBanana = myHashMap.containsKey("banana");
        System.out.println("Có chứa key \"banana\": " + containsBanana);

        // Xóa phần tử có key "cherry"
        myHashMap.remove("cherry");
        System.out.println("Số lượng phần tử sau khi xóa: " + myHashMap.size());
    }
}
