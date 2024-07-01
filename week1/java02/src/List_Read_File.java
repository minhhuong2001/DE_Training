import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
public class List_Read_File {
    public static void main(String[] args) {
        // list các file
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
	    System.out.println("Nhập đường dẫn đến folder");
	    String directoryPath = scanner.nextLine();
         //String directoryPath= "D:\\hoang\\workspace\\java\\DE_Training\\week1\\data";
        listFiles(directoryPath);

        // Đọc nội dung file
        System.out.println("\nEnter the name of the file to read:");
	     String fileName = scanner.nextLine();
	    String filePath = directoryPath +'/'+ fileName;
        readFileContent(filePath);
    }

    public static void listFiles(String directoryPath) {
        try {
            File directory = new File(directoryPath);
            File[] files = directory.listFiles();

            if (files != null) {
                System.out.println("Các file trong thư mục:");
                for (File file : files) {
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("Không thể đọc thư mục.");
            }
        } catch (SecurityException e) {
            System.out.println("Không có quyền truy cập thư mục: " + e.getMessage());
        }
    }

    public static void readFileContent(String filePath) {
        try {
            Path path = Paths.get(filePath);
            List<String> lines = Files.readAllLines(path);

            System.out.println("Nội dung file:");
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Không thể đọc file: " + e.getMessage());
        }
    }
}