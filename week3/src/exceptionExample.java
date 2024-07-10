import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class exceptionExample {
    public static void main(String[ ] args) {
        // Checked Exception
        try {
            FileReader file = new FileReader("myfile.txt");
            int data = file.read();
            while (data != -1) {
                System.out.print((char) data);
                data = file.read();
            }
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("File không được tìm thấy!");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file!");
        }

        // UnChecked Exception
        int[] myNumbers = {1, 2, 3};
        try {
            System.out.println(myNumbers[10]);
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
        try {
            int zero = 0;
            int average = 10 / zero;
            System.out.println("Average = " + average);
        } catch (ArithmeticException ex) {
            System.out.println(ex);
        }
        System.out.println("Finished!");
    }
}
