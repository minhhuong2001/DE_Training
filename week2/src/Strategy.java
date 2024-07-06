import java.util.Arrays;

// Giao diện chung
interface Sort {
    void sort(int[] arr);
}

// Lớp triển khai - Sắp xếp bọt
class BubbleSort implements Sort {
    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

// Lớp triển khai - Sắp xếp chọn
class SelectionSort implements Sort {
    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}

// Lớp sử dụng
class SortClient {
    private Sort sortStrategy;

    public SortClient(Sort sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void sort(int[] arr) {
        sortStrategy.sort(arr);
    }
}

public class Strategy {
    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 1, 3};

        SortClient client = new SortClient(new BubbleSort());
        client.sort(arr);
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 4, 5]

        client = new SortClient(new SelectionSort());
        client.sort(arr);
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 4, 5]
    }
}
